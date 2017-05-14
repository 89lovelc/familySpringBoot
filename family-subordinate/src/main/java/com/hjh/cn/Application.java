package com.hjh.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
