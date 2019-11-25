package com.wjz.springboot.config;

import com.wjz.springboot.domain.User;
import com.wjz.springboot.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class UserConfiguration {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("iss002");
        return user;
    }

    @Bean
    public Date date() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-07");
    }

    /*
    @Bean
    public UserServiceImpl userService() {
        return new UserServiceImpl();
    }
    */
}
