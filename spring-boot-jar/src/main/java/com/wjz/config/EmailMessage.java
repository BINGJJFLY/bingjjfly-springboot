package com.wjz.config;

public class EmailMessage {
    private String msg;

    public EmailMessage(String msg) {
        this.msg = msg;
    }

    public void email(String msg) {
        System.out.println(msg);
    }

    public void msg() {
        System.out.println(msg);
    }
}
