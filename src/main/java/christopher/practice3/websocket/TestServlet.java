package christopher.practice3.websocket;

import christopher.practice1.RabbitMQConsumerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/pratice3/websocket")
public class TestServlet {
    @Autowired
    WebSocket webSocket;
    @Autowired
    RabbitMQConsumerExample rabbitMQConsumerExample;

    @RequestMapping("/monitorMQConsumeSpeed")
    public void monitorMQConsumeSpeed(){
        int interval = rabbitMQConsumerExample.getInterval();
        new Runnable(){
            @Override
            public void run() {
                while (1==1){
                    long start = rabbitMQConsumerExample.getCount();
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int end = rabbitMQConsumerExample.getCount();
                    int v = new BigDecimal(end-start).divide(new BigDecimal(interval)).multiply(new BigDecimal(1000)).intValue();
                    System.out.println("V："+v);
                    webSocket.sendMessage(String.valueOf(v));
                }
            }
        }.run();
    }
}
