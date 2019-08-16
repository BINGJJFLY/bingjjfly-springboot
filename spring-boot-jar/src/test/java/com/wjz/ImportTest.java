package com.wjz;

import com.wjz.config.EmailAutoConfiguration;
import com.wjz.config.EmailMessage;
import com.wjz.config.EmailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void importBean() {
        boolean contains = context.containsBean("helloService");
        System.out.println(contains);
    }

    @Autowired
    EmailAutoConfiguration.EmailSender emailSender;

    @Test
    public void emailSender() {
        System.out.println(emailSender.power());
        System.out.println(emailSender.type());
        System.out.println(emailSender.qqName());
        System.out.println(emailSender.dreams());
        System.out.println(emailSender.time());
    }

    @Autowired
    EmailSender sender;

    @Test
    public void send() {
        sender.send("@Import('')");
    }

    @Autowired
    EmailMessage ems;

    @Test
    public void ems() {
        ems.email("inner configuration");
    }
}
