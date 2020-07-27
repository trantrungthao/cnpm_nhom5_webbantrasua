package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDatabase {
	//
	public Connection getConnectDB() {
		Connection connection = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/webbantrasua?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";
			try {
				connection = DriverManager.getConnection(url, "root", "1234");

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("fail");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("fail");
		}
		
		return connection;

	}
	public  void excuteSql(String sql) throws Exception{
		Connection connect =getConnectDB();
		Statement stmt =    connect.createStatement();
		stmt.executeUpdate(sql);
	}
	public ResultSet selectData(String sql) throws Exception{
		Connection connect =getConnectDB();
		Statement stmt =    connect.createStatement();
		ResultSet rs=	stmt.executeQuery(sql);
		return rs;
	}
}
