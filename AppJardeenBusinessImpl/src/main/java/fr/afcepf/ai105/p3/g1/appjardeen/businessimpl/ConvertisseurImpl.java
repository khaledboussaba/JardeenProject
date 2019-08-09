package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.Convertisseur;

@Remote(Convertisseur.class)
@Stateless
public class ConvertisseurImpl implements Convertisseur {

	@Override
	public Date ConversionDate(String chaineDate, String heure) {

		String[] elementsDate = chaineDate.split(" ");
		System.out.println("elementsDate : " + elementsDate.length);
		String mois = elementsDate[1];
		String jour = elementsDate[2];
		String annee = elementsDate[5];
		Date dateConvertie = new Date();
		
		heure = heure.substring(0, heure.length() - 2);
		if (Integer.parseInt(heure) < 10) {
			heure = "0" + heure;
		}

		switch (mois) {
			case "Jan":
				mois = "01";
				break;
			case "Feb":
				mois = "02";
				break;
			case "Mar":
				mois = "03";
				break;
			case "Apr":
				mois = "04";
				break;
			case "May":
				mois = "05";
				break;
			case "Jun":
				mois = "06";
				break;
			case "Jul":
				mois = "07";
				break;
			case "Aug":
				mois = "08";
				break;
			case "Sep":
				mois = "09";
				break;
			case "Oct":
				mois = "10";
				break;
			case "Nov":
				mois = "11";
				break;
			case "Dec":
				mois = "12";
				break;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			dateConvertie = formatter.parse(annee + "-" + mois + "-" + jour + " " + heure + ":00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateConvertie;
	}
}