
package com.example.EmailService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
@Data
public class AppConfig {
    @Value("${mail.smtp.auth}")
    private boolean smtpAuth;

    @Value("${mail.smtp.host}")
    private String smtpHost;

    @Value("${mail.smtp.user}")
    private String smtpUser;

    @Value("${mail.smtp.password}")
    private String smtpPassword;


    @Bean
    public EmailUtil emailUtil() {
        return new EmailUtil(smtpHost, smtpUser, smtpPassword);
    }
}
