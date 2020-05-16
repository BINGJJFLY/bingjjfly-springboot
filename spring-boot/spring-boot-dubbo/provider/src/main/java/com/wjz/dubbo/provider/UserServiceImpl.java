package com.wjz.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.wjz.dubbo.api.UserService;

@Service(version = "1.0")
public class UserServiceImpl implements UserService {
	
    @Override
    public String hello() {
        return "i am server";
    }
}
