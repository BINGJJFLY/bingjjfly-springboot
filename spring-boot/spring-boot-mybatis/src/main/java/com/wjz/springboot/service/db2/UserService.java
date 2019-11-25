package com.wjz.springboot.service.db2;

import com.wjz.springboot.domain.User;

public interface UserService {

    User selectById(Integer id);

    void insert(User user);
}
