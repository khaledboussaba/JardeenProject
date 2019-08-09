package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.VolontariatAdherent;

public interface VolontariatAdherentDao extends GenericDao<VolontariatAdherent> {

	List<Tache> getTacheVolontariatByIdAdherent(int idAdherent);
	List<Adherent> getAdherentsVolontaireByIdTache(Tache tache);
}
