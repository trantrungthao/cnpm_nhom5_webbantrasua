package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SanPhamDAO;
import model.SanPham;

@WebServlet("/Quanlysanpham")
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			SanPhamDAO SPDAO = new SanPhamDAO();
			List<SanPham> sanpham = SPDAO.listSP();
			req.setAttribute("sanphamList", sanpham);
			req.getRequestDispatcher("/admin/adminquanlysanpham.jsp").forward(req, res);
		} catch (SQLException e) {
			throw new ServletException("Lỗi kết nối DataBase", e);
		}
	}

	// Khi người dùng nhập các thông tin sản phẩm, và nhấn Submit.
	// Phương thức này sẽ được gọi.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		// Lấy dữ liệu từ trang jsp
		String masp = req.getParameter("masanpham");
		String tensp = req.getParameter("tensanpham");
		String hinhanh = req.getParameter("hinhanh");
		double gia = Double.parseDouble(req.getParameter("giaban"));
		// Kiểm tra mã sản phẩm
		if(masp!=null) {
		try {
			// Nếu mã sản phẩm không tồn tại
			if (checkMasp(masp)) {
				SanPham SP = new SanPham(masp, tensp, hinhanh, gia);
				SanPhamDAO SPD = new SanPhamDAO();
				// Thêm sản phẩm vào database
				SPD.insert(SP);
				// Trả về trang quản lý sản phẩm
				res.sendRedirect(req.getContextPath() + "/Quanlysanpham");
			} else {
				// Nếu mã sản phẩm tồn tại
				String er = "Mã sản phẩm đã tồn tại";
				// Thông báo
				req.setAttribute("Error", er);
				// Trả về trang thêm sản phẩm
				req.getRequestDispatcher(req.getContextPath() + "/admin/adminthemsanpham.jsp").forward(req, res);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	}

	// Kiểm tra mã sản phẩm tồn tại hay chưa
	private boolean checkMasp(String masp) throws SQLException {
		SanPhamDAO SPD = new SanPhamDAO();
		List<SanPham> sanpham = SPD.listSP();
		for (SanPham sp : sanpham) {
			if (sp.getMasp() == masp) {
				return false;
			}
		}

		return true;
	}
}
