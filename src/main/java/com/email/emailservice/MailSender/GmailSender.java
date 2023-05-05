package com.email.emailservice.MailSender;

import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailSender {

    @Value("${mail}")
    String mailPassword;
    
    public boolean sendEmail(String from, String to, String subject, String text){
        boolean flag = false;
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        System.out.println(mailPassword);
        String user = "You Username";
        String password = "Your Password";

        Session session = Session.getInstance(props, new Authenticator() {

            @Override
            protected PasswordAuthentication  getPasswordAuthentication(){
                return new PasswordAuthentication(user, password);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
