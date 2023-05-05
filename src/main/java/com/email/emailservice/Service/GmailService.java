package com.email.emailservice.Service;

import org.springframework.stereotype.Service;

import com.email.emailservice.MailSender.GmailSender;

@Service
public class GmailService {

    public void send() {
        GmailSender gmailSender = new GmailSender();
        String to = "To";
        String from = "From";
        String subject = "Sending Mail";
        String text = "From Spring boot";
        boolean sendEmail = gmailSender.sendEmail(from, to, subject, text);

        if (sendEmail) {
            return;
        } else {
            throw new RuntimeException("Sending Failed");
        }
    }
}
