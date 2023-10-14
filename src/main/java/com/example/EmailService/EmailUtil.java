package com.example.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class EmailUtil {

    public EmailUtil(String smtpHost, String smtpUser, String smtpPassword) {
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(EmailUtil.class.getClassLoader().getResourceAsStream("config.properties"));
        return properties;
    }


    public static void sendEmail(String to, String subject, String text)
            throws MessagingException, IOException {
        System.out.println("приплыли в sendEmail в EmailUtil: "+to+" "+subject+" "+text);
        Properties properties = loadProperties();
        Session mailSession = Session.getDefaultInstance(properties);

        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(properties.getProperty("mail.smtp.user")));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(text);

        Transport tr = mailSession.getTransport();
        tr.connect(properties.getProperty("mail.smtp.host"), Integer.parseInt(properties.getProperty("mail.smtp.port")), properties.getProperty("mail.smtp.user"),properties.getProperty("mail.smtp.password"));

        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
    }
}
