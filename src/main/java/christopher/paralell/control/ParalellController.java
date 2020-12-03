package christopher.paralell.control;

import christopher.system.dbSource.OpenJdbcUtil;
import christopher.system.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParalellController {
    @Autowired
    OpenJdbcUtil openJdbcUtil;

    //    AtomicInteger a = new AtomicInteger(0);
    volatile int a = 0;
    boolean status = false;
    @RequestMapping("/system")
    public String scheduledPage(){
//        a = new Random().nextInt(100);
        //        a.incrementAndGet();
        a++;
        System.out.println("--------RESULT-------- "+a);
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

    @RequestMapping("/system2")
    public String scheduledPage2(){
//        a.incrementAndGet();
        a++;
        System.out.println("--------RESULT-------- "+a);
        return "/system/system";
    }
}
