package com.example.EmailService;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController

public class EmailController {

    final private JavaMailSender mailSender;

    public EmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/")
    public String emailPage(){return "email";}

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestParam("email") String email, @RequestParam("body") String body) {
        SimpleMailMessage emailMessage = new SimpleMailMessage();
        emailMessage.setTo(email);
        emailMessage.setSubject("Subject");
        emailMessage.setText(body);

        mailSender.send(emailMessage);

        return ResponseEntity.ok("Email отправлен");
    }
}
