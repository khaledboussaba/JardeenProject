package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.EmplacementBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.EmplacementDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Emplacement;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

@Remote(EmplacementBusiness.class)
@Stateless
public class EmplacementBusinessImpl implements EmplacementBusiness{

	@EJB 
	EmplacementDao proxyEmplacementDao;
	
	//??
	@Override
	public Emplacement obtenirEmplacementByNumLigneEtNumColonne(int numLigne, int numColonne, Terrain terrain) {
		return proxyEmplacementDao.getEmplacementByTerrainAndNumColonneAndNumLigne(numLigne, numColonne, terrain);
	}

	//??
	@Override
	public String obtenirCouleurEmplacement(Emplacement e) {
		return proxyEmplacementDao.getCouleurEmplacementByEmplacement(e);
	}

	// ??
	@Override
	public Parcelle obtenirParcelleViaNumLigneEtNumColonne(int numLigne, int numColonne) {
		return proxyEmplacementDao.getParcelleByNumLigneAndNumColonne(numLigne, numColonne);
	}

	@Override
	public List<Emplacement> obtenirTousLesEmplacementsDontLesParcellesSontNonRetirerByTerrain(Terrain terrain) {
		return proxyEmplacementDao.getAllEmplacementDesParcellesNonRetireByTerrain(terrain);
	}

	@Override
	public List<Emplacement> obtenirListeEmplacementByParcelle(Parcelle p1) {
		return proxyEmplacementDao.getAllEmplacementByParcelle(p1);
	}

	@Override
	public void supprimer(Emplacement e) {
		proxyEmplacementDao.remove(e);
	}
}