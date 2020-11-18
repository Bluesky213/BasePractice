package christopher.system.job;

import christopher.system.util.ResultUitl;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

@Slf4j
@Service
public class DynamicTaskJobImpl implements DynamicTaskJobService {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private static Map<String,ScheduledFuture<?>> futures = new HashMap<>();//存放任务

    @Value("${energy.job.group:}")
    private String jobGroup ;

    //默认启动时

    /**
     * 后续启动
     */
    @PostConstruct
    public void init(){
        (new Thread(
            new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        initJobs();
                    } catch (InterruptedException e) {
                       log.error("延迟启动任务失败",e);
                    }
                }
            }
        )).start();
    }


    public void initJobs() {
        ColumnMapRowMapper rowMapper = new ColumnMapRowMapper();
        String sql = "select * from s_job where state = '1' and cron is not null and bean is not null " ;
        if(StringUtils.isNoneEmpty(jobGroup)) {
            sql += " and sort='"+jobGroup+"'" ;
        }
        int[] count = {0} ;
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Map<String, Object> map = rowMapper.mapRow(rs, 1);
                try {
                    count[0] ++ ;
                    startJob(map) ;
                } catch (Exception e) {
                    log.error("任务启动失败，失败原因：{}，任务信息为：{}",e.getMessage(), JSON.toJSONString(map));
                }
            }
        });
        log.info("启动任务完成，合计启动：{}", count[0]);
    }

    @Override
    public Map getJobInfo(String id) {
        return getJobInfo(id,false);
    }

    @Override
    public Map getActiveJobInfo(String id) {
        return getJobInfo(id,true);
    }

    private Map getJobInfo(String id,boolean active) {
        String sql = "select * from s_job where  id=? and cron is not null and bean is not null " ;
        if(active) {
            sql += " and state = '1' " ;
        }
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, id);
        if(list!=null&&list.size()==1) {
            return list.get(0) ;
        }
        return null;
    }

    @Override
    public void startJob(Map map) {
        String id = Objects.toString(map.get("id"),"") ;
        String cron = Objects.toString(map.get("cron"),"") ;
        CronTrigger expression = null;
        try {
            expression = new CronTrigger(cron);
        } catch (Exception e) {
            throw new RuntimeException("时间表达式不合法！") ;
        }
        ScheduledFuture future = threadPoolTaskScheduler.schedule(getRunner(map),expression);
        futures.put(id,future) ;
    }

    @Override
    public void stopJob(String id) {
        if(futures.containsKey(id)) {
            futures.get(id).cancel(true) ;
            futures.remove(id) ;
        }else{
            log.info("任务未启动,id为："+id);
        }
    }

    @Override
    public ResultUitl runJob(Map map) {
        DynmicTaskRunnner runer =  getRunner(map) ;
        runer.run();
        ResultUitl ro = new ResultUitl();
        ro.setData(runer.getResult());
        ro.setMsg(Objects.toString(runer.getResult(),""));
        return ro ;
    }

    /**
     * 生成执行器
     * @param map
     * @return
     */
    private DynmicTaskRunnner getRunner(Map map) {
        String id = Objects.toString(map.get("id"),"") ;
        String bean = Objects.toString(map.get("bean"),"") ;
        final String param = Objects.toString(map.get("param"),null) ;
        Object beanObject = null ;
        Method beanMethod = null ;
        try {
            String method = bean.substring(bean.lastIndexOf(".")+1) ;
            String cls = bean.substring(0,bean.lastIndexOf(".")) ;
            beanObject = applicationContext.getBean(Class.forName(cls));
            if(StringUtils.isEmpty(param)){
                beanMethod = beanObject.getClass().getMethod(method) ;
            }else{
                beanMethod = beanObject.getClass().getMethod(method,String.class) ;
            }
        } catch (Exception e) {
            throw new RuntimeException("任务执行类配置错误，错误原因："+e.getMessage()) ;
        }
        if(beanObject==null||beanMethod==null) {
            throw new RuntimeException("任务执行类或者方法为空！") ;
        }
        return new DynmicTaskRunnner(beanObject,beanMethod,param,id,jdbcTemplate) ;
    }
}
