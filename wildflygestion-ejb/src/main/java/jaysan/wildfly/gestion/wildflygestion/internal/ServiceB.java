package jaysan.wildfly.gestion.wildflygestion.internal;

import java.util.Date;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless
public class ServiceB {
	
	public String donnerDate() {
		return new Date().toString();
	}

}
