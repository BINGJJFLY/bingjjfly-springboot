package com.wjz.args;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/args")
public class ArgsController {
    @Autowired
    private ApplicationArguments args;
    @Value("profile")
    private String profile;

    @RequestMapping("/application")
    public void application() {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        nonOptionArgs.forEach(o -> System.out.println("运行参数（ApplicationArguments方式）：" + o));
        System.out.println("运行参数（@Value方式）：" + profile);
    }
}
