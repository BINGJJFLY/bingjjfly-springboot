package com.wjz.springboot.service.db2;

import com.wjz.springboot.domain.User;
import com.wjz.springboot.mapper.db2.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    @Transactional("db2TransactionManager")
    public void insert(User user) {
        userMapper.insert(user);
    }
}
