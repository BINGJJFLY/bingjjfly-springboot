package com.wjz.controller;

import com.wjz.config.EmailProperties;
import com.wjz.config.validator.SampleProperties;
import com.wjz.profiles.ProfileCompoent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @Value("${server.port}")
    private String port;
    @Value("${db.password}")
    private String password;
    @Autowired
    private EmailProperties emailProperties;
    @Autowired
    private SampleProperties validatorProperties;
    @Autowired
    private ProfileCompoent profileCompoent;

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        StringBuilder html = new StringBuilder();
        html.append("hello SpringBoot!\n")
                .append("password：").append(password)
                .append("email:").append(emailProperties.getPower())
                .append("LastName:").append(emailProperties.getQq().getLastName())
        .append("SessionTimeout:").append(emailProperties.getSessionTimeout().getSeconds())
        .append("BufferSize").append(emailProperties.getBufferSize().toMegabytes())
        .append("Validator-Host:").append(validatorProperties.getHost())
        ;

        return html.toString();
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
