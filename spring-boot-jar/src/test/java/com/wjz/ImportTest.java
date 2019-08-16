package com.wjz;

import com.wjz.config.EmailAutoConfiguration;
import com.wjz.config.EmailMessage;
import com.wjz.config.EmailSender;
import com.wjz.config.EncodingFilter;
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

    /**
     * @Import注解导入@Configuration修饰的类，该类下@Bean均加入容器中
     */
    @Test
    public void send() {
        sender.send("@Import('')");
    }

    @Autowired
    EmailMessage ems;

    /**
     * 内部类修饰@Configuration
     */
    @Test
    public void innerConfiguration() {
        ems.email("inner Configuration");
    }

    @Test
    public void ems() {
        ems.msg();
    }

    /**
     * 相同类方法名不同ems、alibb注入了两个对象，变量名和@Bean方法名（即BeanId）相同则注入对应组件
     */
    @Autowired
    EmailMessage alibb;

    @Test
    public void alibb() {
        alibb.msg();
    }

    @Autowired
    EncodingFilter filter;

    @Test
    public void filter() {
        System.out.println(filter.getEncoding());
    }
}
