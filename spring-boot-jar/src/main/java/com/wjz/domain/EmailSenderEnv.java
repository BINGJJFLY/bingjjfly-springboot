package com.wjz.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:email.properties")
public class EmailSenderEnv {

    @Autowired
    private Environment env;

    public String host() {
        return env.getProperty("email.host");
    }

}
