package jaysan.wildfly.gestion.wildflygestion;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Date;
import java.util.Hashtable;

import jaysan.wildfly.gestion.wildflygestion.internal.ServiceA;
import jaysan.wildfly.gestion.wildflygestion.pub.ServiceRemoteA;

public class ServicesTester {
	
	protected static InitialContext context;
	
	@Test
	public void testServiceRemoteA() throws NamingException {
		ServiceRemoteA service = (ServiceRemoteA) context.lookup("ejb:wildflygestion/wildflygestion-ejb/ServiceMetier!jaysan.wildfly.gestion.wildflygestion.pub.ServiceRemoteA");
		//assertEquals("toto", service.nouveauProduitAuHasard());
		assertEquals("USS Alabama", service.miseAJourProduit("titi"));
	}
	
	@BeforeClass
	public static void testInit() throws NamingException {
		
		Hashtable<Object, Object> props = new Hashtable<>();
        
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
 
		props.put("jboss.naming.client.ejb.context", false);
		props.put("org.jboss.ejb.client.scoped.context", true);
 
		props.put("endpoint.name", "client-endpoint");
		props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
		props.put("remote.connections", "default");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
 
		props.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		props.put("remote.connection.default.host", "127.0.0.1");
		props.put("remote.connection.default.port", "8080");
//		props.put(Context.PROVIDER_URL,"remote://localhost:4447");
//		props.put(Context.SECURITY_PRINCIPAL, "testuser");
//		props.put(Context.SECURITY_CREDENTIALS, "testpassword");
	   
		props.put("jboss.naming.client.ejb.context", true);
		
		context = new InitialContext(props);
		
	}

}
