package com.example.Demo.services;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

//@Service
//public class EmailService {
//	public boolean sendEmail(String subject,String message,String to) {
//		boolean f=false;
//		
//		String from="ferozalircr@gmail.com";
//		String host="smtp.gmail.com";
//		 Properties properties=System.getProperties();
//		 System.out.println("properties"+properties);
//		 
//		 //host set
//		 properties.put("mail.smtp.host", host);
//		 properties.put("mail.smtp.port", "465");
//		 properties.put("mail.smtp.ssl.enable", "true");
//		 properties.put("mail.smtp.ssl.auth", "true");
//		 //step1 :to get the session object
//		 
//		 Session session=Session.getInstance(properties, new Authenticator() {
//
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				
//				return new PasswordAuthentication("ferozalircr@gmail.com", "maun sgev rxea pvik");
//			}
//			 
//		});
//		 session.setDebug(true);
//		 //step 2:composite the message
//		MimeMessage m=new MimeMessage(session);
//		try {
//			m.setFrom(from);
//			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			m.setSubject(subject);
//			m.setText(message);
//			
//			Transport.send(m);
//			System.out.println("send success.......");
//			f=true;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return f;
//		 
//		
//	}
//	
//
//}



@Service
public class EmailService {
    public boolean sendEmail(String subject, String message, String to) {
        boolean f = false;
        
        // Sender's email
        String from = "ferozalircr@gmail.com";
        
        // Configure properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");  // This was missing
        
        // Get session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "maun sgev rxea pvik");
            }
        });
        
        session.setDebug(true);
        
        try {
            // Create message
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(subject);
            
            // For HTML content
            m.setContent(message, "text/html");
            
            // Send message
            Transport.send(m);
            System.out.println("Email sent successfully...");
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}




