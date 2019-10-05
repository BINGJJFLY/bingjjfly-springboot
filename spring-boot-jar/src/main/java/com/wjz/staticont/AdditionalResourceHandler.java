package com.wjz.staticont;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

import java.time.Duration;

/**
 * 添加自定义静态资源映射
 */
@Configuration
public class AdditionalResourceHandler implements WebMvcConfigurer {
    private final ResourceProperties resourceProperties;

    public AdditionalResourceHandler(ResourceProperties resourceProperties) {
        this.resourceProperties = resourceProperties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Duration cachePeriod = resourceProperties.getCache().getPeriod();
        CacheControl cacheControl = resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
        registry.addResourceHandler("/additional/**")
                .addResourceLocations("classpath:/additional/")
                .setCachePeriod(getSeconds(cachePeriod))
                .setCacheControl(cacheControl);
    }

    private Integer getSeconds(Duration cachePeriod) {
        return cachePeriod != null ? (int) cachePeriod.getSeconds() : null;
    }

    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }
}
