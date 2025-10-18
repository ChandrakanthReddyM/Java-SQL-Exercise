package app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDao {
	
	private static final String url ="jdbc:mysql://localhost:3306/library_db";
	private static final String userName="root";
	private static final String password="pass";
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}

}
