package com.wjz.configuration.impt;

import org.springframework.context.annotation.Bean;

public class IBeanConfig {

    @Bean
    public IBean bean() {
        return new IBean();
    }
}
