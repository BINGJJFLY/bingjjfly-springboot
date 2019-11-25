package com.wjz.springboot.mapper.db2;

import com.wjz.springboot.domain.User;
import com.wjz.springboot.domain.Version;

public interface UserMapper {

    User selectById(Integer id);

    void insert(User user);
}
