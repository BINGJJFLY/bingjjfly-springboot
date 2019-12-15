package com.wjz.springboot.config;

import com.wjz.springboot.domain.User;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CacheConfiguration {

    @Bean
    public User user(List<CacheManager> cacheManagers) {
        return new User();
    }

    /**
     * CacheKey生成器
     *
     * @return
     */
    @Bean
    public KeyGenerator myKeyGenerator() {
        return (target, method, params) -> target.getClass().getName() + "." + method.getName() + Arrays.asList(params);
    }
}
