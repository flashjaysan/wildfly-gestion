package jaysan.wildfly.gestion.wildflygestion.internal;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import jaysan.wildfly.gestion.wildflygestion.internal.dao.ProductDAO;
import jaysan.wildfly.gestion.wildflygestion.pub.ServiceRemoteA;
import jaysan.wildfly.gestion.wildflygestion.pub.dto.Product;

@Stateless(name="ServiceMetier")
public class ServiceA implements ServiceRemoteA {

	@Override
	public String nouveauProduitAuHasard() {
		ProductDAO productDao = new ProductDAO();
		Product product = new Product("titi", "toto", "Ships", "tutu", "toutou", "tonton", 10, 20., 3000.);
		productDao.ajouter(product);
		return product.getName();
	}

	@Override
	public String miseAJourProduit(String code) {
		ProductDAO productDao = new ProductDAO();
		Product product = new Product(code, "USS Alabama", "Ships", "1:1", "Universal Studios", "What is that evil thing?", 1, 20000., 3000.);
		productDao.update(product);
		return product.getName();
	}
	
}
