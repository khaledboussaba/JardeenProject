package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.MessagingException;
@ManagedBean(name="mbContact")
@ViewScoped
public class EnvoiMailManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String message;
	private String subject;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String envoiMail() {
		
		String[] recipients = {"javangers.jardeen@gmail.com"};
		String message = "Objet:"+ subject + "/r/n envoyé depuis le site internet jardden : " + this.message ;
		String subject = mail;
		String from = "javengers.jardeen@gmail.com";
		
		System.out.println("tab: " + recipients);
		
		EnvoiMail sendmail = new EnvoiMail() ;
		try {
			sendmail.sendSSLMessage(recipients, subject, message, from);
		} catch (MessagingException e) {
			System.out.println("Massaging Exeption, Le mail n'est pas envoyé.");
			e.printStackTrace();
		}
		System.out.println("send message ok");
		return "/accueilVisiteur.xhtml?faces-redirect=true";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
