package com.wjz.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(version = "1.0")
@Component("service")
public class UserServiceImpl implements UserService {
    @Override
    public String hello() {
        return "i am server";
    }
}
