package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Sexe;

public interface SexeDao extends GenericDao<Sexe> {

	List<Competence> getAll();
}
