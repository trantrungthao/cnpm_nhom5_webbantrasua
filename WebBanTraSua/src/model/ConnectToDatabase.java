package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {
	//
	public Connection getConnectDB() {
		Connection connection = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/webbantrasua?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
			try {
				connection = DriverManager.getConnection(url, "root", "");

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("fail");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("fail");
		}
		
		return connection;

	}
}
