package com.redis.test;

import com.redis.test.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SpringbootApplicationTests {

    @Autowired
    private RedisService redisService;


    @Test
    public void contextLoads() throws Exception {
    }


    /**
     * 插入字符串
     */
    @Test
    public void setString() {
        redisService.set("redis_string_test", "springboot redis test");
        Assert.assertEquals(redisService.get("redis_string_test"), "springboot redis test");
    }


    /**
     * 获取字符串
     */
    @Test
    public void getString() {
        String result = redisService.get("redis_string_test");
        Assert.assertEquals(redisService.get("redis_string_test"), "springboot redis test");
    }


    @Test
    public void remove() {
        redisService.remove("redis_test");
    }

}
