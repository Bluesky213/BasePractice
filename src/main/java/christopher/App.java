package christopher;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Hello world!
 *
 */
@EnableScheduling
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.run(args);
        System.out.println( "Hello World!" );
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
