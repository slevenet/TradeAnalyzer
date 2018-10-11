package exchange.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.*;

@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);


    }
}
