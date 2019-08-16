package com.wjz.config;

import com.wjz.domain.EmailSenderEnv;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Date;
import java.util.List;

@Configuration
@EnableConfigurationProperties({EmailProperties.class})
@Import(EmailSenderConfiguration.class)
public class EmailAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public EmailAutoConfiguration.EmailSender emailSender(EmailProperties emailProperties) {
        return new EmailAutoConfiguration.EmailSender(emailProperties);
    }

    public static class EmailSender {
        private final EmailProperties emailProperties;
        private final EmailSenderEnv env;
        public EmailSender(EmailProperties emailProperties) {
            this.emailProperties = emailProperties;
            this.env = null;
        }
        public EmailSender(EmailSenderEnv env) {
            this.env = env;
            this.emailProperties = null;
        }
        public String power() {
            return emailProperties.getPower();
        }
        public String type() {
            return emailProperties.getType().name();
        }
        public String qqName() {
            return emailProperties.getQq().getLastName();
        }
        public List<String> dreams() {
            return emailProperties.getDreams();
        }
        public Date time() {
            return emailProperties.getTime();
        }

    }

    @Configuration
    static class EmailMessageConfiguration {
        @Bean
        public EmailMessage ems() {
            return new EmailMessage();
        }
    }
}
