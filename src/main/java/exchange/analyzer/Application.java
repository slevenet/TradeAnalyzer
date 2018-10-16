package exchange.analyzer;

import exchange.analyzer.configuration.PathsManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.*;

@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

    }
}
