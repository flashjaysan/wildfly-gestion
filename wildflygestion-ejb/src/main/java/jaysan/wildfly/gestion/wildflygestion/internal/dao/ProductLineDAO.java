package jaysan.wildfly.gestion.wildflygestion.internal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jaysan.wildfly.gestion.wildflygestion.pub.dto.ProductLine;

public class ProductLineDAO extends DAO<ProductLine> {

	private static final String REQUEST_INSERT = "INSERT INTO productlines "
			+ "(productLine, textDescription, htmlDescription) "
			+ "VALUES (?, ?, ?)";

	private static final String REQUEST_UPDATE = "UPDATE productlines SET "
			+ "textDescription = ?, "
			+ "htmlDescription = ? "
			+ "WHERE productLine = ?";
	
	private static final String REQUEST_DELETE = "DELETE FROM productlines WHERE productLine = ?";

	private static final String REQUEST_SELECT = "SELECT "
			+ "productLine, textDescription, htmlDescription, image "
			+ "FROM productlines "
			+ "WHERE productLine = ?";

	private static final String REQUEST_SELECT_ALL = "SELECT "
			+ "productLine, textDescription, htmlDescription, image "
			+ "FROM productlines ";
	
	private static final String REQUEST_SELECT_ALL_WITH_NB_PRODUCTS = "SELECT p.productLine, l.textDescription, count(productCode) "
			+ "FROM products as p "
			+ "INNER JOIN productlines as l "
			+ "ON p.productLine=l.productLine "
			+ "GROUP BY p.productLine";
/*
	@Override
	public boolean create(ProductLine productLine) {
		if (productLine == null || productLine.getLine() == null) {
			throw new IllegalArgumentException("Parametre 'productLine' non valide");
		}
		boolean out = false;
		try (PreparedStatement pstm = 
				connection.prepareStatement(REQUEST_INSERT); ) {	
			pstm.setString(1, productLine.getLine());
			pstm.setString(2, productLine.getTextDescription());
			pstm.setString(3, productLine.getHtmlDescription());
			int res = pstm.executeUpdate();
			out = (res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}

	@Override
	public boolean delete(ProductLine productLine) {
		if (productLine == null || productLine.getLine() == null) {
			throw new IllegalArgumentException("Parametre 'productLine' non valide");
		}
		boolean out = false;
		try (PreparedStatement pstm = 
				connection.prepareStatement(REQUEST_DELETE); ) {	
			pstm.setString(1, productLine.getLine());
			int res = pstm.executeUpdate();
			out = (res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}

	@Override
	public boolean update(ProductLine productLine) {
		if (productLine == null || productLine.getLine() == null) {
			throw new IllegalArgumentException("Parametre 'productLine' non valide");
		}
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(REQUEST_UPDATE); ) {	
			pstm.setString(1, productLine.getTextDescription());
			pstm.setString(2, productLine.getHtmlDescription());
			pstm.setString(3, productLine.getLine());
			int res = pstm.executeUpdate();
			out = (res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}

	@Override
	public ProductLine find(Object productLine) {
		if (productLine == null) {
			throw new IllegalArgumentException("Parametre 'productLine' "
					+ "non valide");
		}
		if (!(productLine instanceof String)) {
			throw new IllegalArgumentException("Le parametre est un "
					+ "productLine, il doit etre de type String");
		}
		ProductLine out = null;
		try (PreparedStatement pstm = 
				connection.prepareStatement(REQUEST_SELECT); ) {	
			pstm.setString(1, (String)productLine);
			try (ResultSet resultSet = pstm.executeQuery();) {				
				if (resultSet.next()) {
					out = new ProductLine(
							resultSet.getString("productLine"), 
							resultSet.getString("textDescription"), 
							resultSet.getString("htmlDescription"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}

	@Override
	public List<ProductLine> findAll() {		
		List<ProductLine> productLines = new ArrayList<ProductLine>();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = 
						statement.executeQuery(REQUEST_SELECT_ALL); ) {				
			while (resultSet.next()) {
				productLines.add(new ProductLine(
						resultSet.getString("productLine"), 
						resultSet.getString("textDescription"), 
						resultSet.getString("htmlDescription")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return productLines;
	}
	*/
}
