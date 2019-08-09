package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AdherentTerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.AdherentTerrainDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.AdherentTerrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;

@Remote(AdherentTerrainBusiness.class)
@Stateless
public class AdherentTerrainBusinessImpl implements AdherentTerrainBusiness {

	@EJB
	private AdherentTerrainDao proxyAdherentTerrain;
	
	
	@Override
	public List<Terrain> obtenirTerrainAdherent(int idAdherent) {
		List<Terrain> terrainsAdherent = proxyAdherentTerrain.getTerrainByAdherent(idAdherent);
		return terrainsAdherent;
	}


	@Override
	public void annullerTerrainFavoris(AdherentTerrain adTerrain) {
		
		proxyAdherentTerrain.remove(adTerrain);
	}


	@Override
	public List<AdherentTerrain> obtenirAdherentTerrain(int idAdherent) {
		List<AdherentTerrain> terrains = proxyAdherentTerrain.getAdherentTerrainByAdherent(idAdherent);
		return terrains;
	}


	@Override
	public void ajouterTerrainFavoris(Adherent adherent, Terrain terrain) {
		AdherentTerrain adherentTerain = new AdherentTerrain();
		adherentTerain.setAdherent(adherent);
		adherentTerain.setTerrain(terrain);
		proxyAdherentTerrain.insert(adherentTerain);
		
		
	}

}
