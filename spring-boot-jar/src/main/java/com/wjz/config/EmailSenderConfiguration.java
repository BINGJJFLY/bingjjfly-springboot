package com.wjz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailSenderConfiguration {

    @Bean
    public EmailSender sender() {
        return new EmailSender();
    }

}
