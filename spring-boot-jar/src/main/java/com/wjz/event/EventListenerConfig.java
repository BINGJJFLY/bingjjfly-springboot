package com.wjz.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Slf4j
@Configuration
public class EventListenerConfig {

    @EventListener
    public void handleEvent(Object event) {
        log.info("事件：{}", event);
    }

    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        log.info("监听到CustomEvent，事件为：{}，发布时间为：{}", event.getMessageEntity(), event.getTimestamp());
    }
}
