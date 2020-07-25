package christopher.practice1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;

public class RabbitMQPrac {

    public static void main(String[] args) {
        /**
         * 1.Create RabbitMq Connection
         */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest"); factory.setPassword("guest");
        factory.setVirtualHost("/"); factory.setHost("39.108.183.232");
        factory.setPort(5672);
        
        /*
        ConnectionFactory factory = new ConnectionFactory();
        try {
            factory.setUri("amqp://guest:guest@39.108.183.232:5672");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        */
        try {
            Connection conn = factory.newConnection();
            /**
             * 2.Create RabbitMQ Channel
             */
            Channel channel = conn.createChannel();
            /**
             * 3.After Create Channel
             */
            channel.queueDeclare("queue", false, false, false, null);
            String message = "Hello world!";
            for(int i = 0;i<1000000;i++){
                // channel.basicPublish(exchange, routingKey, props, body);
                channel.basicPublish("", "queue", null, (message+i).getBytes(Charset.forName("UTF-8")));
            }
            System.out.println(" [x] Sent '" + message + "'");
            channel.close();
            conn.close();
            System.out.println(conn);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}