package com.wjz.controller;

import com.wjz.domain.Dog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/messageConverter")
public class MessageConverterController {

    @RequestMapping("/jackson")
    public Dog jackson() {
        Dog dog = new Dog();
        dog.setName("bingjjfly");
        dog.setBirth(new Date());
        return dog;
    }

}
