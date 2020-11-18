package christopher.system.job;

import christopher.system.util.ResultUitl;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
@EnableScheduling
@RequestMapping("/job/op")
public class DynamicTaskJobControl {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/config.do")
    public String getPage(Model model, HttpServletRequest req){
        return "energy/job/manage" ;
    }
    @RequestMapping("/logs.do")
    public String getLogPage(Model model, HttpServletRequest req){
//        setAllModelParameters(model, req);
        return "energy/job/logs" ;
    }

    @Autowired
    private DynamicTaskJobService dynamicTaskJobService ;

    /**
     * 启动定时器
     * @return
     */
    @RequestMapping("/start.do")
    @ResponseBody
    public ResultUitl startJob(@RequestParam("id") String id){
        Map map = dynamicTaskJobService.getActiveJobInfo(id);
        if(map!=null) {
            try {
                dynamicTaskJobService.startJob(map);
                return ResultUitl.success("任务启动完成") ;
            } catch (Exception e) {
                log.error("启动任务"+id+"失败",e);
                return ResultUitl.fail("500",e.getMessage()) ;
            }
        }else{
            return ResultUitl.fail("500","找不到生效的任务") ;
        }
    }

    /**
     * 停止定时任务
     * @return
     */
    @RequestMapping("/stop.do")
    @ResponseBody
    public ResultUitl stopJob(@RequestParam("id") String id){
        try {
            dynamicTaskJobService.stopJob(id);
            return ResultUitl.success("任务停止完成") ;
        } catch (Exception e) {
            log.error("启动任务"+id+"失败",e);
            return ResultUitl.fail("500",e.getMessage()) ;
        }
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public ResultUitl updateJob(@RequestParam("id") String id){
        Map map = dynamicTaskJobService.getActiveJobInfo(id);
        if(map!=null) {
            try {
                dynamicTaskJobService.stopJob(id);
                dynamicTaskJobService.startJob(map);
                return ResultUitl.success("任务重启完成") ;
            } catch (Exception e) {
                log.error("启动任务"+id+"失败",e);
                return ResultUitl.fail("500",e.getMessage()) ;
            }
        }else{
            return ResultUitl.fail("500","找不到生效的任务") ;
        }
    }

    /**
     * 手动执行任务
     * @return
     */
    @RequestMapping("/run.do")
    @ResponseBody
    public ResultUitl runJob(@RequestParam("id") String id){
        Map map = dynamicTaskJobService.getJobInfo(id);
        if(map!=null) {
            try {
                return dynamicTaskJobService.runJob(map);
            } catch (Exception e) {
                log.error("执行任务"+id+"失败",e);
                return ResultUitl.fail("500",e.getMessage()) ;
            }
        }else{
            return ResultUitl.fail("500","找不到生效的任务") ;
        }
    }

    /**
     * 删除定时任务
     */
    @RequestMapping("/del.do")
    @ResponseBody
    public ResultUitl delJob(@RequestParam("id") String id){
        String delSql = "delete from s_job where id = ? limit 1";
        return ResultUitl.success(jdbcTemplate.update(delSql,id));
    }

    /**
     * 删除定时任务
     */
    @RequestMapping("/edit.do")
    @ResponseBody
    public ResultUitl editJob(@RequestParam("id") String name,String bean,String param,String cron,String state,String memo,String sort){
        String editSql = "replace into s_job(name,bean,param,cron,state,memo,sort) values(?,?,?,?,?,?,?,?) ";
        return ResultUitl.success(jdbcTemplate.update(editSql,name,bean,param,cron,state,memo,sort));
    }

    /**
     * 删除定时任务
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public ResultUitl listJob(){
        String querySql = "select * from s_job order by sort asc ";
        return ResultUitl.success(jdbcTemplate.queryForList(querySql));
    }
}
