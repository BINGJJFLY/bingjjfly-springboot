package com.wjz.config;

import com.wjz.config.conditional.OnObjectCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HTTPProperties.class)
@Conditional(OnObjectCondition.class)
@ConditionalOnProperty(prefix = "spring.http.encoding", value = {"encoding"}, matchIfMissing = true)
public class HTTPAutoConfiguration {

    /**
     * 只有一个有参构造器的情况下，参数的值会自动注入
     */
    private final HTTPProperties httpProperties;

    public HTTPAutoConfiguration(HTTPProperties httpProperties) {
        this.httpProperties = httpProperties;
    }

    @Bean
    public EncodingFilter filter() {
        EncodingFilter filter = new EncodingFilter();
        filter.setEncoding(httpProperties.getEncoding());
        return filter;
    }
}
