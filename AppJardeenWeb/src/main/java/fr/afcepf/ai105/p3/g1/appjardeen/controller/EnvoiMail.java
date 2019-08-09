package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.internet.*;   // important
import javax.mail.event.*;      // important
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnvoiMail {

	private static final String FROM = "javengers.jardeen@gmail.com";
	private static final String FROMNAME = "Jardeen";

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_USERNAME = "javangers.jardeen@gmail.com";
	private static final String SMTP_PASSWORD = "Jardeen1234";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private static final String SMTP_PORT = "465";

	public  void sendSSLMessage(String recipients[], String subject,
			String message, String from) throws MessagingException {

		System.out.println("recipients: " + recipients);
		System.out.println("subject: " + subject);
		System.out.println("message: " + message);
		System.out.println("from: " + from);

		boolean debug = true;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");
		/*ICI LA CONNECXION A LA BOITE MAIL JARDEEN MISE EN SESSION ?*/
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
			}
		});
		session.setDebug(debug);
		Message msg = new MimeMessage(session);
		//InternetAddress addressFrom = new InternetAddress(from);
		//msg.setFrom(addressFrom);
		try {
			// l'envoyeur
			msg.setFrom(new InternetAddress(FROM, FROMNAME));
			// les destinataires
			InternetAddress[] addressTo = new InternetAddress[recipients.length];
			for (int i = 0; i < recipients.length; i++) {
				addressTo[i] = new InternetAddress(recipients[i]);
				msg.setRecipients(Message.RecipientType.TO, addressTo);
				// sujet
				msg.setSubject(subject);
				//corp du mail
				msg.setContent(message, "text/html");
			}
			// envoie du message
			Transport.send(msg);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
}        
