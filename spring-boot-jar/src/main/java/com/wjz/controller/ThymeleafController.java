package com.wjz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@Controller
public class ThymeleafController {

    @RequestMapping("thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("userName", "bingjjfly");
        return "thymeleaf";
    }
}
