package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
			if(tk.getRole()==role) {
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
			//ktEmail
//			public boolean ktEmail(String email) {
//				TaiKhoan tk = mapTaiKhoan.get(email);
//				if(!tk.getEmail().equals(email)){
//					return true;
//				}
//				return false;
//			}
			
//			//ktUsername
//			public boolean ktTendn(String tendangnhap) {
//				TaiKhoan tk = mapTaiKhoan.get(tendangnhap);
//				if(!tk.getTendangnhap().equals(tendangnhap)){
//					return true;
//				}
//				return false;
//			}
			//Kiem tra ten dang nhap da ton tai
			public boolean ktTK(String userName) {
				if(mapTaiKhoan.containsKey(userName)) {
					return false;
				}else {
					return true;
				}
				
			}
			//themTaikhoan
			public void themTaikhoan(TaiKhoan tk) {
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
//		    public boolean kiemTraTaiKhoan(String userName) {
//		        String sql = "SELECT * FROM taikhoan WHERE tendangnhap= '" + userName + "'";
//		        try {
//		        	Connection connection = new ConnectToDatabase().getConnectDB();
//		            PreparedStatement ps = connection.prepareStatement(sql);
//		            ResultSet rs = ps.executeQuery();
//		            while (rs.next()) {
//		                return true;
//		            }
//		            connection.close();
//		        } catch (SQLException ex) {
//		            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
//		        }
//		        return false;
//		    }
}
