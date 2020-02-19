package jaysan.wildfly.gestion.wildflygestion.internal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;
import java.sql.SQLException;

public class ProductDBUtils {
	private String dbms;
	private String driver;
	private String server;
	private String port;
	private String database;
	private String user;
	private String password;
	
	private static ProductDBUtils instance = new ProductDBUtils();
	
	private ProductDBUtils() {
		try {
			loadProperties();
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static ProductDBUtils getInstance() {
		return instance;
	}
	
	
	public Connection getConnection() throws SQLException {
		return DriverManager
	.getConnection("jdbc:" + dbms + "://" + server + ":" + port + "/" + database + "?useLegacyDatetimeCode=false&serverTimezone=UTC", 
			user, password);
	}
	
	private void loadProperties() {
		Properties properties = new Properties();
		try {
			properties.load(ProductDBUtils.class
					.getClassLoader()
					.getResourceAsStream("db-products.properties"));
			dbms = (String)properties.getProperty("dbms");
			driver = (String)properties.getProperty("driver");
			server = (String)properties.getProperty("server");
			port = (String)properties.getProperty("port");
			database = (String)properties.getProperty("database");
			user = (String)properties.getProperty("user");
			password = (String)properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String getDbms() {
		return dbms;
	}

	public String getDriver() {
		return driver;
	}

	public String getPort() {
		return port;
	}

	public String getDatabase() {
		return database;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getServer() {
		return server;
	}

	public String toString() {
		return "ProductDBUtils[" + 
	Arrays.stream(new String[] { dbms, driver, server, port, database, user, "***" })
		.collect(Collectors.joining(", ")) +  "]";
	}

}
