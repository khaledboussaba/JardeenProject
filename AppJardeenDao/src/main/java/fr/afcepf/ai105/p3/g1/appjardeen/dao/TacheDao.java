package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;

public interface TacheDao extends GenericDao<Tache>{

	Tache getLastTacheInParcelle(Parcelle p);
	List<Tache> getAllTacheByPlante(Plante plante);
	List<Tache> getTachesDuJour();
	List<Tache> getTacheManquantDeJardiniers();
	List<Tache> getAll();
}
