package christopher.system.controller;

import christopher.practice1.RabbitMQConsumerExample;
import christopher.practice1.RabbitMQPublishExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("/system")
public class SystemController {
    @Autowired
    RabbitMQConsumerExample rabbitMQConsumerExample;
    @Autowired
    RabbitMQPublishExample rabbitMQPublishExample;

    @RequestMapping("/startMQConsume")
    public String startConsume() throws IOException, TimeoutException {
        rabbitMQConsumerExample.startMQConsume();
        return "ok";
    }

    @RequestMapping("/startMQPublish")
    public void startMQPublish(){
        rabbitMQPublishExample.startMQPublish();
    }
}
