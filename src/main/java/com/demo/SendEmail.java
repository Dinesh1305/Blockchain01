package com.demo;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendEmail {
    static final String EMAIL_USERNAME = "hakihackers@gmail.com";
    static final String EMAIL_PASSWORD = "dxfe plxy dwkv cbwj";

    public static void send(String to) {
        try {
            InternetAddress emailAddr = new InternetAddress(to);
            emailAddr.validate();
        } catch (AddressException ex) {
            System.err.println("Invalid email address: " + ex.getMessage());
            return;
        }

        // SMTP Configuration
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); 
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Force TLS 1.2
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.connectiontimeout", "5000"); // Connection timeout
        props.put("mail.smtp.timeout", "5000");           // Read timeout
        props.put("mail.debug", "true");                  // Enable debugging

        // Create Mail Session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            // Create Email Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Contract Successful!");
            message.setText("Your contract has been processed successfully.");

            // Send Email
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}
