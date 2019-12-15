package com.wjz.springboot.service;

import com.wjz.springboot.domain.User;

import java.util.List;

public interface UserService {

    List<User> select(Integer id);

    List<User> update();

    void delete();

    void save();
}
