package com.wjz.springboot.service;

import com.wjz.springboot.database.Database;
import com.wjz.springboot.domain.User;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
// 公共当前类的每个@Cachexxx的属性值
@CacheConfig(cacheNames = "userCache", keyGenerator = "myKeyGenerator")
public class UserServiceImpl implements UserService {

    /**
     * cacheNames/value：缓存组件的名字，CacheManager找到Cache的依据
     * key/keyGenerator：缓存Key，默认使用方法参数的值，支持SpEL表达式，#root.targetClass, #id, #a0, #result
     * cacheManager/cacheResolver：指定缓存管理器
     * condition：条件判断，#id > 7，符合条件才缓存
     * unless：条件判断，#result == null, 不符合条件才缓存
     * sync：异步，unless条件判断不生效
     * key名字拼接方式：key = "#root.methodName+'['+#id+']'"
     *
     * @return
     */
    @Override
    @Cacheable(value = "userCache", keyGenerator = "myKeyGenerator", condition = "#a0 > 1", unless = "#a0 == 2")
    public List<User> select(Integer id) {
        System.out.println("###################模拟请求数据库###################");
        return Database.users();
    }

    @Override
    @CachePut(value = "userCache", key = "#root.targetClass")
    public List<User> update() {
        System.out.println("###################模拟请求数据库###################");
        List<User> users = Database.users();
        users.forEach(u -> u.setName("UpdateName_" + u.getId()));
        Database.save(users);
        return users;
    }

    /**
     * allEntries：不指定key全清空缓存组
     * beforeInvocation：是否在方法执行之前执行，默认方法执行后执行
     */
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
