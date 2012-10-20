package edu.dhbw.oodb.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.test.jpa.AbstractJpaTests;

public class AbstractDaoTests extends
		AbstractJpaTests {

	private static Connection jdbcConnection;
	
	protected String[] getConfigLocations() {
		return new String[] { "db.xml" };
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	      try {
		      jdbcConnection = DriverManager.getConnection(
					  "jdbc:oracle:thin:@localhost:1521:XE", "tpch", "tpch");
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	      jdbcConnection.close();
	}



	protected void onSetupInTransaction () throws Exception {
		Statement statement = jdbcConnection.createStatement();
		statement.executeUpdate("drop sequence globalsequence");
		statement.executeUpdate("create sequence globalsequence");
	}

	protected void onTearDownInTransaction() throws Exception {
	}
	
}
