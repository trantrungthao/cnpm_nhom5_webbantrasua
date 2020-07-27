package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnectToDatabase;
import model.SanPham;

public class SanPhamDAO{

	public SanPhamDAO() {

	}

	public List<SanPham> listSP() throws SQLException {
		List<SanPham> sanPham = new ArrayList<SanPham>();

		try {
			Connection connection = new ConnectToDatabase().getConnectDB();
			String sql = "SELECT * FROM sanpham";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String masp = rs.getString("masp");
				String tensp = rs.getString("tensp");
				String hinhanh = rs.getString("hinhanh");
				double gia = rs.getDouble("gia");

				SanPham sanpham = new SanPham(masp, tensp, hinhanh, gia);
				sanPham.add(sanpham);
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sanPham;
	}
	// Thêm sản phẩm
	public boolean insert(SanPham sanpham) {
		Connection connection = new ConnectToDatabase().getConnectDB();
		String sql = "Insert into sanpham(masp, tensp, hinhanh, gia) values ('"+sanpham.getMasp()+"','" +sanpham.getTensp() +"','" +sanpham.getHinhanh() +"','" +sanpham.getGia() +"') ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	// Sửa sản phẩm
	public boolean edit(SanPham sanpham) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Xóa sản phẩm
	public boolean delete(String masp) {
		// TODO Auto-generated method stub
		return false;
	}
}
