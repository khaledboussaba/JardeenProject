package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Inscription;

public interface InscriptionDao extends GenericDao<Inscription>{
	List<Inscription> getInscriptionAEcheance();
	String getLastIncriptionDateByAdherent(Adherent adherent);
	List<Adherent> getAllAdherentsInscriptionArrivantAEcheance();	
}
