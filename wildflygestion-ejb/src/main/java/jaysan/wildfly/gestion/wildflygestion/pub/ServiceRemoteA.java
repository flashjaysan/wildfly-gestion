package jaysan.wildfly.gestion.wildflygestion.pub;

import javax.ejb.Remote;

@Remote
public interface ServiceRemoteA {
	
	public String nouveauProduitAuHasard();
	public String miseAJourProduit(String code);

}
