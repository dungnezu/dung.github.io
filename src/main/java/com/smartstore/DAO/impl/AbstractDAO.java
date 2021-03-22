package com.smartstore.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.smartstore.DAO.GenericDAO;
import com.smartstore.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public Connection getConnection() {

		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String username = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		// TODO Auto-generated method stub
		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;

		ResultSet resultSet = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();

				}
			} catch (SQLException e2) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		// TODO Auto-generated method stub
		for (int i = 0; i < parameters.length; i++) {
			Object parameter = parameters[i];
			int index = i + 1;
			if (parameter instanceof Long) {
				try {
					statement.setLong(index, (Long) parameter);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (parameter instanceof String) {
				try {
					statement.setString(index, (String) parameter);
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else if (parameter instanceof Integer) {
				try {
					statement.setInt(index, (int) parameter);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else if (parameter instanceof Timestamp) {
				try {
					statement.setTimestamp(index, (java.sql.Timestamp) parameter);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {

					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		Long id = null;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			// TODO: handle exception
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();

				}
			} catch (SQLException e2) {
				return null;
			}
		}

	}

	@Override
	public int count(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;

		ResultSet resultSet = null;
		try {
			int count = 0;
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			// set parameters
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt("Count(*)");
			}
			return count;
		} catch (Exception e) {
			return 0;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();

				}
			} catch (SQLException e2) {
				return 0;
			}
		}
	}

	@Override
	public void delete(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;

		ResultSet resultSet = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

}
