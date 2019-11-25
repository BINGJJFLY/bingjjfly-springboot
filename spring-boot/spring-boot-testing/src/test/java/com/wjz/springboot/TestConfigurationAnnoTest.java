package com.wjz.springboot;

import com.wjz.springboot.domain.User;
import com.wjz.springboot.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestConfigurationAnnoTest {

    @Autowired
    User user;
    @Autowired
    Date date;
    @Autowired
    UserServiceImpl userService;

    /**
     *
     * @Autowired 注解可以注入@Service组件，但是不能注入 @Configuration 下的 @Bean 组件
     * 需要在 /test/java 下 的 @TestConfiguration 写 @Bean
     *
     */
    @Test
    public void userBean() {
        System.out.println(user);
        System.out.println(date);
        userService.say();
    }
}
