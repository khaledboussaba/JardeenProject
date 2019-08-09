package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.VilleDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Ville;

@Remote( VilleDao.class)
@Stateless
public class VilleDaoImpl extends GenericDaoImpl<Ville> implements VilleDao {

}
