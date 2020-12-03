package christopher.test.controller;

import christopher.practice1.RabbitMQConsumerExample;
import christopher.practice1.RabbitMQPublishExample;
import christopher.system.dbSource.OpenJdbcConfig;
import christopher.system.dbSource.OpenJdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    OpenJdbcUtil openJdbcUtil;

    @RequestMapping("/testOpenJdbc")
    public String testOpenJdbc(){
        OpenJdbcConfig openJdbcConfig2 = new OpenJdbcConfig();
//        openJdbcConfig2.setOpenJdbcTemplate();
        long start = System.currentTimeMillis();
        List<Map<String, Object>> mapList = openJdbcUtil.getJt().queryForList("select * from s_job ");
        long end = System.currentTimeMillis();
        System.out.println(end-start+"ms3");//50ms左右，建立jdbc连接后的第一次查询效率很低 800ms
        return "ok";
    }
}
