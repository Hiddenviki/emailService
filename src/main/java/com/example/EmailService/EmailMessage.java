package com.example.EmailService;


public class EmailMessage {

    private String email;
    private String subject;
    private String body;

    public EmailMessage() {
        email = "pinveselkova@yandex.ru";
        subject = "Спишь?";
        body = "Обернись! Они сзади...";
    }

    // геттеры и сеттеры
    public String getEmail() {
        return this.email;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "EmailMessage(email=" + this.getEmail() + ", subject=" + this.getSubject() + ", body=" + this.getBody() + ")";
    }

}
