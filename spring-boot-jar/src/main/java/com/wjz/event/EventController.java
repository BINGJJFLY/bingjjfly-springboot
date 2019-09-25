package com.wjz.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/push")
    public void push(String code, String message) {
        publisher.publishEvent(new CustomEvent(this, MessageEntity.builder().code(code).message(message).build()));
    }
}
