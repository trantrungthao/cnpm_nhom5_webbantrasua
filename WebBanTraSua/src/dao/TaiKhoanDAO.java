package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.TaiKhoan;

public class TaiKhoanDAO {
	public Map<String, TaiKhoan> mapTaiKhoan = loadData();

	public TaiKhoanDAO() {

	}

	public Map<String, TaiKhoan> loadData() {
		//
		Map<String, TaiKhoan> listTK = new HashMap<>();
		try {
			Connection connection = new ConnectToDatabase().getConnectDB();
			String sql = "SELECT * FROM taikhoan";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String tendangnhap = rs.getString("tendangnhap");
				String matkhau = rs.getString("matkhau");
				String hovaten = rs.getString("hovaten");
				String email = rs.getString("email");
				String sdt = rs.getString("sodienthoai");
				String role = rs.getString("role");

				TaiKhoan tk = new TaiKhoan(tendangnhap, matkhau, hovaten, sdt, email, role);
				listTK.put(tk.getTendangnhap(), tk);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTK;

	}

	// Kiểm tra tài khoản Admin
	public boolean checkAdmin(String tendangnhap, String role) {
		TaiKhoan tk = mapTaiKhoan.get(tendangnhap);
		// nếu tk có trong map
		if (tk != null) {
			if (tk.getRole().equals(role)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Kiểm tra đăng nhập
	public boolean checkLogin(String tendangnhap, String matkhau) {
		TaiKhoan tk = mapTaiKhoan.get(tendangnhap);
		// nếu tk có trong map
		if (tk != null) {
			if (tk.getMatkhau().equals(matkhau)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Kiem tra ten dang nhap da ton tai
	public boolean ktTK(String tendangnhap) {
		if (mapTaiKhoan.containsKey(tendangnhap)) {
			return false;
		} else {
			return true;
		}

	}

	// themTaikhoan
	public void themTaikhoan(TaiKhoan tk) {
		Connection connection = new ConnectToDatabase().getConnectDB();
		String sql = "Insert into taikhoan(tendangnhap, matkhau, email) values ('" + tk.getTendangnhap() + "','"
				+ tk.getMatkhau() + "','" + tk.getEmail() + "') ";
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
