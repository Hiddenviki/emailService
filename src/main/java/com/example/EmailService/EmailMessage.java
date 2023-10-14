package com.example.EmailService;

import lombok.Data;

@Data
public class EmailMessage {

    private String email; //куда посылаем
    private String subject; //тема сообщения
    private String body; //текст сообщения

    public EmailMessage(String email, String subject, String body) {
        this.email=email;
        this.subject=subject;
        this.body=body;
    };


}
