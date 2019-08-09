package fr.afcepf.ai105.p3.g1.appjardeen.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.business.CompetenceBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.dao.CompetenceDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Competence;

@Remote(CompetenceBusiness.class)
@Stateless
public class CompetenceBusinessImpl implements CompetenceBusiness {

	@EJB
	private CompetenceDao proxyCompetenceDao;
	
	@Override
	public List<Competence> listerCompetences() {
		List<Competence> competences = proxyCompetenceDao.getAll();
		return competences;
	}
}
