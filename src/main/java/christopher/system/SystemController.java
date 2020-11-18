package christopher.system;

import christopher.practice1.RabbitMQConsumerExample;
import christopher.system.dbSource.DataSourceModel;
import christopher.system.dbSource.OpenJdbcConfig;
import christopher.system.dbSource.OpenJdbcUtil;
import christopher.system.util.HttpClientUtil;
import com.rabbitmq.client.AMQP;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class SystemController {
    @Autowired
    OpenJdbcUtil openJdbcUtil;
    @Autowired
    RabbitMQConsumerExample rabbitMQConsumerExample;

//    AtomicInteger a = new AtomicInteger(0);
    volatile int a = 0;
    boolean status = false;
    @RequestMapping("/system")
    public String scheduledPage(){
//        a = new Random().nextInt(100);
        if(!status){
            for(int i = 0;i<10;i++){
                System.out.println(a+":"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                status=true;
            }
        }
        return "/system/system";
    }

    @RequestMapping("/system2")
    public String scheduledPage2(){
//        a.incrementAndGet();
        a++;
        System.out.println("--------RESULT-------- "+a);
        return "/system/system";
    }

    @RequestMapping("/job")
    public String jobPage(){
//        a.incrementAndGet();
        a++;
        System.out.println("--------RESULT-------- "+a);
        return "/system/job";
    }

    @RequestMapping("/post1")
    public String startPost1(){
        long start = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            HttpClientUtil.doPost("http://127.0.0.1:8080/system2","","utf-8");
        }
        long end = System.currentTimeMillis();
        System.out.println("---"+(end-start)+"----");
        return "/system/system";
    }

    @RequestMapping("/post2")
    public String startPost2(){
        for(int i=0;i<1000;i++){
            HttpClientUtil.doPost("http://127.0.0.1:8080/system2","","utf-8");
        }
        return "/system/system";
    }

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

    @RequestMapping("/startConsume")
    public String startConsume() throws IOException, TimeoutException {
        rabbitMQConsumerExample.test();
        return "ok";
    }
}
