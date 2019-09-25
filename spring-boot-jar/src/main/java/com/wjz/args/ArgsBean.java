package com.wjz.args;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArgsBean {

    @Autowired
    public ArgsBean(ApplicationArguments args) {
        List<String> nonOptionArgs = args.getNonOptionArgs();
        nonOptionArgs.forEach(o -> System.out.println(o));
    }
}
