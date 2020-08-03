package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.TaiKhoan;

public class TaiKhoanDAO{
	public Map<String, TaiKhoan> mapTaiKhoan = loadData();

	public TaiKhoanDAO() {
		
	}
	public Map<String, TaiKhoan> loadData(){
		//
		Map<String, TaiKhoan> listTK = new HashMap<>();
		try {
			Connection connection = new ConnectToDatabase().getConnectDB();
			String sql = "SELECT * FROM taikhoan";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userName = rs.getString("tendangnhap");
				String passWord = rs.getString("matkhau");
				String Name = rs.getString("hovaten");
				String email = rs.getString("email");
				String sdt = rs.getString("sodienthoai");
				String role = rs.getString("role");
				
				TaiKhoan tk = new TaiKhoan(userName, passWord, Name, sdt, email, role);
				listTK.put(tk.getTendangnhap(), tk);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTK;
		
		
	}
	//checkAdmin
	public boolean checkAdmin(String userName, String role) {
		TaiKhoan tk = mapTaiKhoan.get(userName);
		//nếu tk có trong map
		if(tk!=null) {
			if(tk.getRole().equals(role)) {
				return true;
			}else {
				return false;
			}
		}else {
		return false;
		}
	}
	
	//checkLogin
			public boolean checkLogin(String userName, String passWord) {
				TaiKhoan tk = mapTaiKhoan.get(userName);
				//nếu tk có trong map
				if(tk!=null) {
					if(tk.getMatkhau().equals(passWord)) {
						return true;
					}else {
						return false;
					}
				}else {
				return false;
				}
			}
			//ktTaikhoan
			public boolean ktTaikhoan(String userName, String email) {
				TaiKhoan tk = mapTaiKhoan.get(userName);
				if(tk.getEmail().equals(email)){
					return false;
				}
				return true;
			}
			//themTaikhoan
			public void themTaikhoan (TaiKhoan tk) {
				Connection connection = new ConnectToDatabase().getConnectDB();
				String sql = "Insert into taikhoan(tendangnhap, matkhau, email) values ('"+tk.getTendangnhap()+"','" +tk.getMatkhau() +"','" +tk.getEmail() +"') ";
				try {
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.executeUpdate(sql);
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}

