package com.wjz.springboot.controller;

import com.wjz.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/index_1")
    public String index_1() {
        return "Success.";
    }

    @ResponseBody
    @RequestMapping("/index_2")
    public String index_2() {
        int i = 1 / 0;
        return "Success.";
    }

    @RequestMapping("/index_3")
    public String index_3() {
        return "index_3";
    }

    @Autowired
    User user;
    @Autowired
    Date date;

    @ResponseBody
    @RequestMapping("/user")
    public User user() {
        return user;
    }

    @ResponseBody
    @RequestMapping("/date")
    public Date date() {
        return date;
    }
}
