package edu.dhbw.oodb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDao {

	private static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user="tpch";
	private static final String passwd="tpch";

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, passwd);
		return connection;
	}
	
}
