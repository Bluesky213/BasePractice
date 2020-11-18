package christopher.system.job;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Data
public class DynmicTaskRunnner implements Runnable {
    private JdbcTemplate jdbcTemplate;
    private String jobId ;

    private Object obj ;
    private Method method ;
    private String param ;

    private Object result ;
    private int state = 0 ;
    private long cost ;

    public DynmicTaskRunnner(Object obj, Method method, String param, String jobId, JdbcTemplate jdbcTemplate) {
        this.obj = obj ;
        this.method = method ;
        this.param = param ;
        this.jobId = jobId ;
        this.jdbcTemplate = jdbcTemplate ;
    }

    @Override
    public void run() {
        long s = System.currentTimeMillis() ;
        try {
            if(StringUtils.isEmpty(param)){
                result = method.invoke(obj) ;
            }else{
                result = method.invoke(obj,param) ;
            }
            state = 1 ;
        } catch (Exception e) {
            log.error("任务执行失败",e);
            result = e.getMessage() ;
        }finally {
            cost = System.currentTimeMillis()-s ;
            insertLog();
        }
    }

    /**
     * 保存日志
     */
    private void insertLog() {
        try {
            if(result!=null&&result.toString().length()>2000) {
                result = result.toString().substring(0,2000) ;
            }
            String ip = null;
            try {
                InetAddress localHost = Inet4Address.getLocalHost();
                ip = localHost.getHostAddress();
            } catch (UnknownHostException e) {
                log.error(e.getMessage(),e);
            }
            jdbcTemplate.update("insert into s_job_log(jobid,state,msg,cost,memo) values (?,?,?,?,?)",jobId,state,result,cost,ip) ;
        } catch (Exception e) {
            log.error("保存日志失败",e);
        }
    }
}
