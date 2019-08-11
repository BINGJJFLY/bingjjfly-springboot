package com.wjz;

import com.wjz.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 *      驱动器使用SpringRunner，而不是Junit
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YamlTest {

    @Autowired
    Person person;

    @Test
    public void yaml() {
        System.out.println(person);
    }
}
