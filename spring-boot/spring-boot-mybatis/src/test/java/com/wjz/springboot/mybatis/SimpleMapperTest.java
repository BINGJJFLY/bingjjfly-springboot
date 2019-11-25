package com.wjz.springboot.mybatis;

import com.wjz.springboot.domain.User;
import com.wjz.springboot.domain.Version;
import com.wjz.springboot.service.db1.VersionService;
import com.wjz.springboot.service.db2.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleMapperTest {

    @Autowired
    @Qualifier("db1DataSource")
    DataSource db1DataSource;
    @Autowired
    @Qualifier("db2DataSource")
    DataSource db2DataSource;
    @Autowired
    VersionService versionService;
    @Autowired
    UserService userService;

    @Test
    public void db1() {
        try {
            System.out.println(db1DataSource.getClass().getName());
            System.out.println(db1DataSource.getConnection().getMetaData().getUserName());
            System.out.println(db1DataSource.getConnection().getMetaData().getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void db2() {
        try {
            System.out.println(db2DataSource.getClass().getName());
            System.out.println(db2DataSource.getConnection().getMetaData().getUserName());
            System.out.println(db2DataSource.getConnection().getMetaData().getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectVersion() {
        System.out.println(versionService.selectById(1));
    }

    @Test
    public void selectUser() {
        System.out.println(userService.selectById(1));
    }

    @Test
    public void insertVersion() {
        Version version = new Version();
        version.setVersion("2.0.0");
        versionService.insert(version);
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("beijing");
        userService.insert(user);
    }
}
