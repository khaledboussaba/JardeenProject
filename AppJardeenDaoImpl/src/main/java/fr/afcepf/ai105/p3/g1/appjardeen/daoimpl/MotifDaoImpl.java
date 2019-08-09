package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.MotifTacheDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.MotifTache;

@Remote(MotifTacheDao.class)
@Stateless
public class MotifDaoImpl extends GenericDaoImpl<MotifTache> implements MotifTacheDao {


}
