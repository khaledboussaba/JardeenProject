package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.Date;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.OutilTache;

public interface OutilTacheDao extends GenericDao<OutilTache>{

	int getQuantiteUtilisee(Date dateHeureDebut, Date dateHeureFin, Outil outil);
}
