package it.polito.tdp.meteo.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static private final String jdbcUrl = "jdbc:mysql://localhost/meteo?user=root";
	static private DBConnect instance = null ;
	
	private DBConnect () {
		instance = this ;
		//System.out.println("instance created") ;
	}
	
	public static DBConnect getInstance() {
		if(instance == null)
			return new DBConnect() ;
		else {
			//System.out.println("instance reused") ;
			return instance ;
		}
	}
	
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl) ;
			return conn ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Cannot get connection "+jdbcUrl, e) ;
		}	
	}

}
