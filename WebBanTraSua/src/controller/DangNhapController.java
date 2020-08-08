package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaiKhoanDAO;
import model.TaiKhoan;

@WebServlet(urlPatterns = { "/Dangnhap" })
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DangNhapController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Nhận dữ liệu từ trang đăng nhập
		String action = req.getParameter("action");
		String tendangnhap = req.getParameter("tendangnhap");
		String matkhau = req.getParameter("matkhau");
//		// Nhận mã captcha
//		String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
//		boolean verify = Captcha.verify(gRecaptchaResponse);
		
		// Tạo 1 phiên làm việc lưu lại trảng thái người dùng
		HttpSession session = req.getSession();
		// Xử lý đăng nhập
		if (action.equals("dangnhap")) {
			TaiKhoanDAO TKD = new TaiKhoanDAO();
			// Lấy danh sách tài khoản trong database
			Map<String, TaiKhoan> listTK = TKD.loadData();
			// Kiểm tra tài khoản và mật khẩu
			if (TKD.checkLogin(tendangnhap, matkhau)) {
				// Kiểm tra quyền admin
				if (TKD.checkAdmin(tendangnhap, "admin")) {
					TaiKhoan tk = listTK.get(tendangnhap);
					session.setAttribute("tk", tk);
					// Chuyển qua trang admin
					res.sendRedirect(req.getContextPath() + "/admin/adminindex.jsp");
				} else {
					TaiKhoan tk = listTK.get(tendangnhap);
					session.setAttribute("tk", tk);
					// Chuyển qua trang chủ
					res.sendRedirect("trangchu.jsp");
				}
			} else {
//				// Mã captcha
//				String captcha = "<div class=\"g-recaptcha\" data-sitekey=\"6LdXdiMUAAAAAKirZUzx5jMHJ-Gs65uX-Kw5K7YF\"></div>";
//				req.setAttribute("captcha", captcha);
				req.setAttribute("error", "  *Tài khoản hoặc mật khẩu không đúng");
				// Chuyển lại trang đăng nhập
				req.getRequestDispatcher("dangnhap.jsp").forward(req, res);
			}

		}
		//
		else if (action.equals("dangxuat")) {
			session.invalidate();
			res.sendRedirect("trangchu.jsp");
		//
//		}else if(action.equals("captcha")) {
//			
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
