package fr.afcepf.ai105.p3.g1.appjardeen.dao;

import java.util.List;

import fr.afcepf.ai105.p3.g1.appjardeen.entities.Plante;

public interface PlanteDao extends GenericDao<Plante> {

	List<Plante> getAll();
	List<Plante> getPlantesEnPeriodeDeSemis();
	List<Plante> getPlantesEnPeriodeDeFloraison();
	List<Plante> getPlantesEnPeriodeDeRecolte();
}