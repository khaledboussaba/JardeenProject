package fr.afcepf.ai105.p3.g1.appjardeen.daoimpl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai105.p3.g1.appjardeen.dao.HumiditeSolDao;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.HumiditeSol;

@Remote(HumiditeSolDao.class)
@Stateless
public class HumiditeSolDaoImpl extends GenericDaoImpl<HumiditeSol>  implements HumiditeSolDao{

}
