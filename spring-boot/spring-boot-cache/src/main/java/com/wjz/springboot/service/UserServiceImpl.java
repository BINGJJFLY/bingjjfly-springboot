package com.wjz.springboot.service;

import com.wjz.springboot.database.Database;
import com.wjz.springboot.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    @Cacheable(value = "userCache", key = "getTargetClass()")
    public List<User> index() {
        System.out.println("###################模拟请求数据库###################");
        return Database.users();
    }

    @Override
    @CachePut(value = "userCache", key = "getTargetClass()")
    public List<User> update() {
        System.out.println("###################模拟请求数据库###################");
        List<User> users = Database.users();
        users.forEach(u -> u.setName("UpdateName_" + u.getId()));
        Database.save(users);
        return users;
    }

    @Override
    @CacheEvict(value = "userCache", key = "getTargetClass()")
    public void delete() {

    }

    @Override
    @Caching(cacheable = {
            @Cacheable(value = "userCache", key = "getTargetClass()")
    },
    put = {
            @CachePut(value = "userCache", key = "getTargetClass()")
    },
    evict = {
            @CacheEvict(value = "userCache", key = "getTargetClass()", allEntries = true)
    })
    public void save() {
        List<User> users = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("Save_" + i);
            users.add(user);
        }
        Database.save(users);
    }
}
