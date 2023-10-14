//package com.example.EmailService;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//@Configuration
//@PropertySource("classpath:config.properties")
//public class AppConfig {
//    @Value("${mail.transport.protocol}")
//    private String transportProtocol;
//
//    @Value("${mail.smtps.auth}")
//    private boolean smtpsAuth;
//
//    @Value("${mail.smtps.host}")
//    private String smtpsHost;
//
//    @Value("${mail.smtps.user}")
//    private String smtpsUser;
//
//    @Value("${mail.smtps.password}")
//    private String smtpsPassword;
//
//    @Bean
//    public EmailService yourMailService(JavaMailSender javaMailSender) {
//        return new EmailService(javaMailSender);
//    }
//
//    @Bean
//    public JavaMailSender javaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(smtpsHost);
//        mailSender.setPort(465); // порт SMTP-сервера
//        mailSender.setUsername(smtpsUser);
//        mailSender.setPassword(smtpsPassword); // пароль
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", transportProtocol);
//        props.put("mail.smtp.auth", smtpsAuth);
//
//        return mailSender;
//    }

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
