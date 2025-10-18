package app;

import java.sql.Connection;
import java.sql.SQLException;

import app.util.AbstractDao;

public class Application {
	
	public static void main(String[] args) {
		System.out.println("Hello world!!!!");
		try {
			Connection dao = AbstractDao.getConnection();
			System.out.print("Connection Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
