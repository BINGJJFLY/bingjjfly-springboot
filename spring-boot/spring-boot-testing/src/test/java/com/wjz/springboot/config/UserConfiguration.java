package com.wjz.springboot.config;

import com.wjz.springboot.domain.User;
import com.wjz.springboot.service.UserServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@TestConfiguration
public class UserConfiguration {

    @Bean
    public User user() {
        User user = new User();
        user.setId(7);
        user.setName("hello");
        return user;
    }

    @Bean
    public Date date() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01");
    }

    @Bean
    public UserServiceImpl userService() {
        return new UserServiceImpl();
    }
}
