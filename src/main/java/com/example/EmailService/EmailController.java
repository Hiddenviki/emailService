//package com.example.EmailService;

////import org.springframework.mail.SimpleMailMessage;
////import org.springframework.mail.javamail.JavaMailSender;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
////оно тут вообще походу не надо
//public class EmailController {
////
////    private final EmailService emailService;
////
////    public EmailController(JavaMailSender mailSender, EmailService emailService) {
////        this.emailService = emailService;
////    }
//
//    @GetMapping("/")
//    public String emailPage() {
//        return "email";
//    }
//
////    @PostMapping("/sendEmail")
////    public void sendEmail(@RequestParam("email") String email,
////                          @RequestParam("body") String body) {
////
////        emailMessage.setTo(email);
////        emailMessage.setSubject("no-reply");
////        emailMessage.setText(body);
////
////        emailService.sendEmail(emailMessage);
////
////    }
//}
