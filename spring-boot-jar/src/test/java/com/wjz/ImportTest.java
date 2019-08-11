package com.wjz;

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
}
