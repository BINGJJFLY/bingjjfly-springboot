package com.wjz.dubbo.consumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wjz.dubbo.api.UserService;

@RestController
public class UserController {

	@Reference(version = "1.0")
	private UserService userService;

	@RequestMapping("/hello")
	public String hello() {
		return userService.hello();
	}
}
