package com.wjz.configure;

import com.wjz.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeans {

    /**
     * 注解形式代替XML形式
     * 返回值为Bean实例，方法名为Bean的Id
     *
     * @return
     */
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

}
