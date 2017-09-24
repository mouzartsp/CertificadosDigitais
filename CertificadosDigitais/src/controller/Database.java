package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
//	public static Connection getConnection() throws SQLException {
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/certificados_digitais?useSSL=false", "root","root");
//		return connection;
//	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://mysql.mpiinformatica.com/mpiinformatica19?useSSL=false", "mpiinformatica19","abcd102030");
		return connection;
	}

}
