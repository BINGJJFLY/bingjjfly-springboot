package com.wjz.config.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

@Configuration
public class ValidatorConfiguration {

    @Bean
    public static Validator configurationPropertiesValidator() {
        return new SamplePropertiesValidator();
    }
}
