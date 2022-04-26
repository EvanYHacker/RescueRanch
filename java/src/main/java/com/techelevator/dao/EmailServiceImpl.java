package com.techelevator.dao;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{


    private JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("donotreply@rescueranch.io");
        mailSender.setPassword(")Rks4_awNV#98.Q\"3JWf;B");


        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }


    private JavaMailSender emailSender = getJavaMailSender();

    public void setEmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    public void sendSimpleMessage(
            String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("donotreply@rescueranch.io");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }

    /*
    public static void main(String[] args){
        EmailServiceImpl emailService = new EmailServiceImpl();
        //emailService.sendSimpleMessage("devwithev@gmail.com", "Hello Evan", "Here is an Automated Email");
        //emailService.sendSimpleMessage("camrong0623@gmail.com", "Hello Cameron", "Here is an Automated Email");
        emailService.sendSimpleMessage("jamesmiller.nc@gmail.com", "Hello Jim", "Here is an Automated Email");
    }

     */
}
