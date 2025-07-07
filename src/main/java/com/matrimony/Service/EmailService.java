package com.matrimony.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService
{
    @Autowired
    private JavaMailSender mailSender;

    public void sendWelcomeEmail(String toEmail, String userName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Maratha Matrimony");
        message.setText("Dear " + userName + ",\n\nThank you for registering on Maratha Matrimony!\n\nWe hope you find your perfect match.\n\nBest regards,\nTeam Maratha Matrimony");

        mailSender.send(message);
    }
}
