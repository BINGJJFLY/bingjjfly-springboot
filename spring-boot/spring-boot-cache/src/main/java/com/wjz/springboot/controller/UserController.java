package com.wjz.springboot.controller;

import com.wjz.springboot.domain.User;
import com.wjz.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public List<User> index() {
        return userService.index();
    }

    @RequestMapping("/update")
    public List<User> update() {
        return userService.update();
    }

    @RequestMapping("/delete")
    public String delete() {
        userService.delete();
        return "Success.";
    }
}
