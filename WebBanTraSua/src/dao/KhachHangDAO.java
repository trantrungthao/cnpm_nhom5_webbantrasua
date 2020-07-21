package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.TaiKhoan;

public class KhachHangDAO {
	public static Map<String, TaiKhoan> mapTaiKhoan = loadData();

	public KhachHangDAO() {
		
	}
	private static Map<String, TaiKhoan> loadData(){
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
			
			
			public static void main(String[] args) {
				KhachHangDAO khDAO = new KhachHangDAO();
				System.out.println(khDAO.checkLogin("admin", "123456"));

			}
}

