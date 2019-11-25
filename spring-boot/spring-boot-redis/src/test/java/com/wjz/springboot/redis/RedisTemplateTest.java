package com.wjz.springboot.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTemplateTest {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void set() {
        redisTemplate.opsForValue().set("hello", "world");
    }
}
