package com.journaldev.maven.classes;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SMSSender {

	public static boolean sendOtpToCustomer(int otp,String email)
	{
		String mymail="swethad2021@gmail.com";
        // Sender's email credentials
        final String username = mymail;
        final String password = "yuaw sppg uosy owwf";
        String e=email;
        char ch[]=e.toCharArray();
        String front = ""; 
        String back = ""; 
        for(int i=0;i<e.length();i++)
        {
        	if(ch[i]=='@')
        	{
        		front=e.substring(0,i);
        		back=e.substring(i+1);
        		break;
        	}
        }
        String message = String.valueOf(otp);
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Authenticator object for sending email
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Session object
        Session session = Session.getInstance(props, auth);

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(username));
            emailMessage.setRecipients(Message.RecipientType.TO,InternetAddress.parse(front+"@"+back));
            emailMessage.setSubject("OTP for Parcel Delivery");
            emailMessage.setText("Your One Time Password to receive your parcel"+message);
            Transport.send(emailMessage);

            System.out.println("SMS sent successfully!");
            return true;

        } catch (MessagingException e1) {
            e1.printStackTrace();
            System.out.println("Failed to send SMS.");
        }
		return false;
	}
}
