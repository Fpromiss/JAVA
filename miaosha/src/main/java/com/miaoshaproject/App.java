package com.miaoshaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration // app启动类设置为springboot的bean并且能够开启整个工程的自动配置
@RestController // 设置springMVC controller
public class App 
{
    // 访问根路径 输出hello world
    @RequestMapping("/")
    public String home(){
        return "hello world";
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // 启动springboot项目
        SpringApplication.run(App.class, args);
    }
}
