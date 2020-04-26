package com.example.sweater.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/** A class that generates a mail sender config. */
@Configuration
public class MailConfig {
    /** A host of the sender address. */
    @Value("${spring.mail.host}")
    private String host;

    /** An username of the sender address. */
    @Value("${spring.mail.username}")
    private String username;

    /** A password of the sender address. */
    @Value("${spring.mail.password}")
    private String password;

    /** A port of the sender address. */
    @Value("${spring.mail.port}")
    private int port;

    /** A protocol of the sender address. */
    @Value("${spring.mail.protocol}")
    private String protocol;

    /** A debug of the sender address. */
    @Value("${mail.debug}")
    private String debug;

    /**
     * A method that returns a mail sender.
     * @return mail sender
     */
    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties properties = mailSender.getJavaMailProperties();

        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.debug", debug);

        // For google mails
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        return mailSender;
    }
}
