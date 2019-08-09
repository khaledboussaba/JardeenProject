package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Timeout implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setMaxInactiveInterval(86400); //pour que le timeout dans 1 heure 
		System.out.println("Session timeout dans: " + se.getSession().getMaxInactiveInterval()/60 + " minute");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session détruite, vous allez être redirigé vers la page connexiont timeout, peut être");
	}
}