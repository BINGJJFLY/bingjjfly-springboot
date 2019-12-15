package com.wjz.springboot;

import com.wjz.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CacheTest {

    @Autowired
    UserService userService;

    @Test
    public void index() {
        System.out.println(userService.select(1));
    }
}
