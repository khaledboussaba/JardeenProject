package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

public class MailBusinessImpl {
	public static  void notifierAdherent(Adherent adherent, Tache tache, String typeNotification) {
		String objetMail = "NULL";
		String contenuMail = "NULL";
		switch(typeNotification){
		case "reportee" : 
			objetMail ="Report de la tache n°"+tache.getIdTache()+" : "+tache.getLibelleTache();
			contenuMail= "Bonjour "+adherent.getPrenom()+",\n";
			contenuMail += "Nous tenons à vous informer que la tache n°"+tache.getIdTache()+" : "+tache.getLibelleTache()+" a été reporté.";
			contenuMail += "Elle se déroulera du "+tache.getDateDebutTache()+" au "+tache.getDateFinTache();
			contenuMail += "\n Nous vous remercions pour votre compréhension.";
			contenuMail += "\n \n \n Jardeen";
			break; 

		case "annulee"  : 
			objetMail= "OBJET";
			contenuMail= "OBJET";
			break; 

		case "pasDispo" : 	
			objetMail= "OBJET";
			contenuMail= "OBJET";
			break; 
		default : 
			break;
		}
		sendMail("redamehidi@gmail.com", objetMail, contenuMail);
	}

	public static boolean sendMail(String mailDestinataire, String objetMail, String contenuMail ) {
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		try {
			// Création du mail
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("admin@jardeen.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailDestinataire));
			message.setSubject(objetMail);
			message.setText(contenuMail);

			Transport.send(message);
			return true ;
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return false;
	}

	public static void testMail() {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.mailtrap.io");
		prop.put("mail.smtp.port", "25");
		prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("redamehidi@gmail.com", "motDePasse");
			}
		});

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("redamehidi@gmail.com"));
			message.setRecipients(
					Message.RecipientType.TO, InternetAddress.parse("redamehidi@gmail.com"));
			message.setSubject("Mail Subject");

			String msg = "This is my first email using JavaMailer";

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
