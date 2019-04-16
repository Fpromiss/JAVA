package com.miaoshaproject;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 *
 */
// app启动类设置为springboot的bean并且能够开启整个工程的自动配置 并且 配置扫描包
@SpringBootApplication(scanBasePackages = {"com.miaoshaproject"})
@RestController // 设置springMVC controller
@MapperScan("com.miaoshaproject.dao")
public class App 
{
    @Autowired
    private UserDOMapper userDOMapper;

    // 访问根路径 输出hello world
    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if(userDO == null){
            return "用户对象不存在";
        }else{
            return userDO.getName();
        }
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // 启动springboot项目
        SpringApplication.run(App.class, args);
    }
}
