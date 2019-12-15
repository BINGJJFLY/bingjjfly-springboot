package com.wjz.springboot.starter;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    @Autowired
    HelloProperties properties;

    public String sayHello(String name) {
        return properties.getPrefix() + "-" + name + "-" + properties.getSuffix();
    }
}
