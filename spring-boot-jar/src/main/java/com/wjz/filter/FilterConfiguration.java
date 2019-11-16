package com.wjz.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan({"com.wjz.filter", "com.wjz.servlet", "com.wjz.listener"})
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean filter_1() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Filter_1());
        registrationBean.addInitParameter("target", "true");
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
