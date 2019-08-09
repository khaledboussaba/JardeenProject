package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Actions;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Outil;

public interface OutilDao extends GenericDao<Outil>{

	List<Outil> getByDateAndAction(Date dateHeureDebut, Date dateHeureFin, Actions action);
	List<Outil> getByDate(Date dateHeureDebut, Date dateHeureFin);
	List<Outil> getAll();
}
