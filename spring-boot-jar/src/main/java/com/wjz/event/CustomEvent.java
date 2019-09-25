package com.wjz.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    private MessageEntity messageEntity;

    public CustomEvent(Object source, MessageEntity messageEntity) {
        super(source);
        this.messageEntity = messageEntity;
    }

    public MessageEntity getMessageEntity() {
        return messageEntity;
    }
}
