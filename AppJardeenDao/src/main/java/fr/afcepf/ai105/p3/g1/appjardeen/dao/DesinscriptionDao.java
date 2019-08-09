package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Desinscription;

public interface DesinscriptionDao extends GenericDao<Desinscription> {

	List<Desinscription> getAllDesinscriptionsByAdherent(Adherent adherent);

	List<Adherent> getAll();

}
