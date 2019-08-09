package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.IndisponibiliteBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.IndisponibiliteDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Adherent;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Indisponibilite;

@Remote(IndisponibiliteBusiness.class)
@Stateless
public class IndisponibiliteBusinessImpl implements IndisponibiliteBusiness {

	@EJB
	private IndisponibiliteDao proxyIndispo;
	


	@Override
	public void insertIndispo(Adherent adherent, Date dateDebutIndispo, Date dateFinIndispo) {
		Indisponibilite indispo =new Indisponibilite();
		indispo.setAdherent(adherent);
		indispo.setDebutDateIndisponibilite(dateDebutIndispo);
		indispo.setFinDateIndisponibilite(dateFinIndispo);
		proxyIndispo.insert(indispo);
	}

	@Override
	public Indisponibilite update(Indisponibilite indispo, Date dateDebIndispo, Date dateFIndispo) {
		indispo.setDebutDateIndisponibilite(dateDebIndispo);
		indispo.setFinDateIndisponibilite(dateFIndispo);
		return proxyIndispo.update(indispo);
	}


	@Override
	public Indisponibilite obtenirIndisponibilite(int idIndiponibilite) {
		
		return proxyIndispo.findById(idIndiponibilite);
	}

	@Override
	public void annulerIndispo(Indisponibilite indispo) {
		proxyIndispo.remove(indispo);
	}

	@Override
	public List<Indisponibilite> listerIndisponibilites(Adherent adherent) {
		return proxyIndispo.getIndisponibilitesByAdherent(adherent);
	}


	
	
	

	
}
