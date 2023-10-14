package com.example.EmailService;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQRegistrationConsumer {

    private final EmailService emailService;

    public RabbitMQRegistrationConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    //метод будет вызван при получении сообщения из указанной очереди (your-queue-name).
    @RabbitListener(queues = "email-queue")
    public void receiveMessage(@Header("Operation") String header,
                               @Payload String message) {

        System.out.println("Операция: " + header);
        System.out.println("Получили сообщение: \n" + message);
        // Создаю экземпляр Gson
        Gson gson = new Gson();
        // Преобразую JSON-строку в объект MessageDTO
        MessageDTO messageDTO = gson.fromJson(message, MessageDTO.class);
        if (header.equals("Registration")) {
            System.out.println("зашли в условие в RabbitMQRegistrationConsumer");
            String email = messageDTO.getEmail();
            String subject = "Успешная регистрация";
            String body = messageDTO.getFirstName() + " " + messageDTO.getLastName() + " "
                    + "ваша регистрация в сервисе доставки прошла успешно!";
            EmailMessage emailMessage = new EmailMessage(email, subject, body);

            // Отправляю письмо с использованием EmailService
            emailService.sendEmail1(emailMessage);
        }
        //else if (header.equals("Other")) {
//
//        }

    }

}
