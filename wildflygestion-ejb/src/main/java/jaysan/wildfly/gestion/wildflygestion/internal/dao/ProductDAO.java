package jaysan.wildfly.gestion.wildflygestion.internal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jaysan.wildfly.gestion.wildflygestion.pub.dto.Product;

public class ProductDAO extends DAO<Product> {

	private static final String REQUEST_INSERT = "INSERT INTO products "
			+ "(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String REQUEST_UPDATE = "UPDATE products SET "
			+ "productName = ?, "
			+ "productLine = ?, "
			+ "productScale = ?, "
			+ "productVendor = ?, "
			+ "productDescription = ?, "
			+ "quantityInStock = ?, "
			+ "buyPrice = ?, "
			+ "MSRP = ? "
			+ "WHERE productCode = ?";
	
	private static final String REQUEST_DELETE = "DELETE FROM products WHERE productCode = ?";

	private static final String REQUEST_SELECT = "SELECT "
			+ "productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP "
			+ "FROM products "
			+ "WHERE productCode = ?";

	private static final String REQUEST_SELECT_ALL = "SELECT "
			+ "productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP "
			+ "FROM products ";
/*
	@Override
	public boolean create(Product product) {
		if (product == null || product.getCode() == null) {
			throw new IllegalArgumentException("Parametre 'product' non valide");
		}
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(REQUEST_INSERT); ) {	
			pstm.setString(1, product.getCode());
			pstm.setString(2, product.getName());
			pstm.setString(3, product.getLine());
			pstm.setString(4, product.getScale());
			pstm.setString(5, product.getVendor());
			pstm.setString(6, product.getDescription());
			pstm.setInt(7, product.getQuantityInStock());
			pstm.setDouble(8, product.getBuyPrice());
			pstm.setDouble(9, product.getMsrp());
			int res = pstm.executeUpdate();
			out = (res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}
	*/
	
	public boolean ajouter(Product product) {
		ArrayList<Object> params = new ArrayList<>();
		params.add(product.getCode());
		params.add(product.getName());
		params.add(product.getLine());
		params.add(product.getScale());
		params.add(product.getVendor());
		params.add(product.getDescription());
		params.add(product.getQuantityInStock());
		params.add(product.getBuyPrice());
		params.add(product.getMsrp());
		return super.create(REQUEST_INSERT, params);
	}
	
/*
	@Override
	public boolean delete(Product product) {
		if (product == null || product.getCode() == null) {
			throw new IllegalArgumentException("Parametre 'product' non valide");
		}
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(REQUEST_DELETE); ) {	
			pstm.setString(1, product.getCode());
			int res = pstm.executeUpdate();
			out = (res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}
	*/

	public boolean update(Product product) {
		ArrayList<Object> params = new ArrayList<>();
		params.add(product.getName());
		params.add(product.getLine());
		params.add(product.getScale());
		params.add(product.getVendor());
		params.add(product.getDescription());
		params.add(product.getQuantityInStock());
		params.add(product.getBuyPrice());
		params.add(product.getMsrp());
		params.add(product.getCode());
		return super.update(REQUEST_UPDATE, params);
	}

	/*
	public Product find(Object productCode) {
		Product product = null;
		List<Object> objects = super.find(REQUEST_SELECT, productCode);
		if (objects != null) {
			product = new Product(
					(String)(objects.get(0)),
					(String)(objects.get(1)), 
					(String)(objects.get(2)),
					(String)(objects.get(3)),
					(String)(objects.get(4)),
					(String)(objects.get(5)),
					(int)(objects.get(6)),
					(double)(objects.get(7)),
					(double)(objects.get(8)));
		}
		return product;
	}
	*/

	/*
	@Override
	public List<Product> findAll() {		
		List<Product> products = new ArrayList<Product>();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(REQUEST_SELECT_ALL); ) {				
			while (resultSet.next()) {
				products.add(new Product(
						resultSet.getString("productCode"), 
						resultSet.getString("productNAme"), 
						resultSet.getString("productLine"),
						resultSet.getString("productScale"),
						resultSet.getString("productVendor"),
						resultSet.getString("productDescription"),
						resultSet.getInt("quantityInStock"),
						resultSet.getDouble("buyPrice"),
						resultSet.getDouble("MSRP")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return products;
	}
	*/
}
