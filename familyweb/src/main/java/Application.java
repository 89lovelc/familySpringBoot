import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Created by 89lovelc on 2017/4/9.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.hjh.cn")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }

}
