package com.wjz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 主程序
 * 类位置在必须com.wjz下，否则Bean扫描异常
 */
//@ImportResource({"classpath:spring-beans.xml"})
@SpringBootApplication
public class SpringBootJarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJarApplication.class, args);
    }
}
