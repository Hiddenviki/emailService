package com.example.EmailService;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class EmailService {
//    private final JavaMailSender javaMailSender;
//
//    public EmailService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }


    // Метод для отправки письма
    public void sendEmail1(EmailMessage emailMessage) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(emailMessage.getEmail());
//        message.setSubject(emailMessage.getSubject());
//        message.setText(emailMessage.getBody());
//        javaMailSender.send(message);
        System.out.println("попали в sendEmail в EmailService");
        try {
            System.out.println("попали в try в sendEmail");
            EmailUtil.sendEmail(emailMessage.getEmail(), emailMessage.getSubject(), emailMessage.getBody());
            System.out.println("Письмо отправлено.");
        }catch (MessagingException | IOException e) {
            System.out.println("попали в catch в sendEmail");
            e.printStackTrace();
        }

    }
}


