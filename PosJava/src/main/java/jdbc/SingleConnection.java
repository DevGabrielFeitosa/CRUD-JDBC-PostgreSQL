package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;
	
	private static void conectar() {
		try {
				
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}

	public static Connection getConnection() {
		return connection;
	}
	
	
	
}
