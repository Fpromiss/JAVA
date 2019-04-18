package com.redis.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Fpromiss
 */
@RestController
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class App 
{
    public static void main( String[] args )
    {
        // 启动springboot项目
        SpringApplication.run(App.class, args);
    }
}
