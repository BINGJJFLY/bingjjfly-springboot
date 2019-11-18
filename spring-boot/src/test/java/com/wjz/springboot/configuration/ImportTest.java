package com.wjz.springboot.configuration;

import com.wjz.springboot.configuration.impt.IBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportTest {

    @Autowired
    private IBean bean;

    @Test
    public void firstName() {
        System.out.println(bean.firstName());
    }

    @Test
    public void lastName() {
        System.out.println(bean.lastName());
    }

}
