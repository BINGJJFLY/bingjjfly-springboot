package com.wjz.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prev")
public class ProfileConfiguration {

    @Bean
    public ProfileCompoent profileCompoent() {
        return new ProfileCompoent();
    }

}
