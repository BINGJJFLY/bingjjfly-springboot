package com.wjz.controller;

import com.wjz.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class NegotiationController {

    @RequestMapping("/negotiation")
    public User negotiation() {
        User user = new User();
        user.setName("bingjjfly");
        user.setBirth(new Date());
        return user;
    }

    @RequestMapping("/negotiation/index")
    public String index() {
        return "thymeleaf";
    }
}
