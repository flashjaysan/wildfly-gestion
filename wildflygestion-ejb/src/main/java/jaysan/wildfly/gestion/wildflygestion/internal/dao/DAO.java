package jaysan.wildfly.gestion.wildflygestion.internal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DAO<T> {
	protected Connection connection = null;
	
	public DAO() {
		try {
			connection = ProductDBUtils.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public boolean create(String sql, List<Object> params) {
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(sql);) {
			for (int i = 0; i < params.size(); ++i) {
				Object param = params.get(i);
				if (param instanceof String) {
					pstm.setString(i + 1, (String)param);
				}
				if (param instanceof Integer) {
					pstm.setInt(i + 1, (int)param);
				}
				if (param instanceof Double) {
					pstm.setDouble(i + 1, (double)param);
				}
			}
			int res = pstm.executeUpdate();
			out = (res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;	
	}
	
	/*
	public boolean delete(String sql, List<Object> params) {
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(sql);) {	
			pstm.setString(1, obj.getCode());
			int res = pstm.executeUpdate();
			out = (res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}
	*/
	
	public boolean update(String sql, List<Object> params) {
		boolean out = false;
		try (PreparedStatement pstm = connection.prepareStatement(sql);) {
			for (int i = 0; i < params.size(); ++i) {
				Object param = params.get(i);
				if (param instanceof String) {
					pstm.setString(i + 1, (String)param);
				}
				if (param instanceof Integer) {
					pstm.setInt(i + 1, (int)param);
				}
				if (param instanceof Double) {
					pstm.setDouble(i + 1, (double)param);
				}
			}
			int res = pstm.executeUpdate();
			out = (res == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return out;
	}
	
	/*
	public Map<String,Object> find(String sql, Object key) {
		
		Map<String,Object> map = new HashMap<>();
		
		
		try (PreparedStatement pstm = connection.prepareStatement(sql); ) {	
			pstm.setString(1, (String)key);
			try (ResultSet resultSet = pstm.executeQuery()) {
				int countColumns = resultSet.getMetaData().getColumnCount();
				for (int count=0; count < countColumns;++count) {
				String nom = resultSet.getMetaData().getColumnName(count);
				resultSet.getMetaData().getPrecision(count);
				
				if(java.sql.Types.VARCHAR == resultSet.getMetaData().getColumnType(count)) map.put(nom, resultSet.getString(count));

			}						
				if (resultSet.next()) {
					// j'ai fait du caca
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}
	*/
	
	/*
	public List<T> findAll() {
		
	}
	*/
}
