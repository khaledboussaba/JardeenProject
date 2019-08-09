package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.ParcelleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.ParcelleDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

@Remote(ParcelleBusiness.class)
@Stateless
public class ParcelleBusinessImpl implements ParcelleBusiness {

	@EJB
	ParcelleDao proxyParcelleDao;
	
	@Override
	public List<Parcelle> listerParcelles() {
		return proxyParcelleDao.getAll();
	}

	@Override
	public void modifierParcelle(Parcelle parcelle, String libilleParcelle, 
			TypeSol typeSol, Terrain terrain, Acidite acidite, Date dateCreation, Date dateRetrait) {
		parcelle.setLibelleParcelle(libilleParcelle);
		parcelle.setTypeSol(typeSol);
		parcelle.setTerrain(terrain);
		parcelle.setAcidite(acidite);
		parcelle.setDateCreationParcelle(dateCreation);
		parcelle.setDateRetraitParcelle(dateRetrait);
		proxyParcelleDao.update(parcelle);
	}
	
	@Override
	public List<Parcelle> listerParcellesTerrain(Terrain terrain) {
		return proxyParcelleDao.getParcellesByTerrain(terrain);
	}

	@Override
	public void createParcelle(String libelleParcelle, TypeSol typeSol, Terrain terrain, Acidite acidite,
			Date dateCreation) {
		Parcelle parcelle = new Parcelle();
		parcelle.setLibelleParcelle(libelleParcelle);
		parcelle.setTerrain(terrain);
		parcelle.setAcidite(acidite);
		parcelle.setTypeSol(typeSol);
		parcelle.setDateCreationParcelle(dateCreation);
		proxyParcelleDao.insert(parcelle);
		
	}
	@Override
	public void creerParcelle(Parcelle parcelle) {
		proxyParcelleDao.insert(parcelle);
		
	}

	@Override
	public void modifierParcelle(Parcelle parcelle) {
		proxyParcelleDao.update(parcelle);
		
	}

	@Override
	public List<Parcelle> obtenirToutesLesParcellesByTerrain(Terrain terrain) {
		return proxyParcelleDao.getAllParcelleByTerrain(terrain);
	}

	@Override
	public List<Parcelle> obtenirToutesLesParcellesRetireesByTerrain(Terrain terrain) {
		return proxyParcelleDao.getAllParcelleRetireesByTerrain(terrain);
	}

	@Override
	public void supprimerDefinitivementParcelle(Parcelle p) {
		proxyParcelleDao.remove(p);
		
	}
	

}
