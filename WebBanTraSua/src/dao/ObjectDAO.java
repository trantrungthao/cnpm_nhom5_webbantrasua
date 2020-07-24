package dao;

import model.SanPham;

public interface ObjectDAO {
	boolean insert(SanPham sanpham);

	boolean edit(SanPham sanpham);

	boolean delete(String masp);
}
