package controller;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaiKhoanDAO;
import mail.SendMail;
import model.TaiKhoan;



@WebServlet(urlPatterns = { "/dangky" })
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DangKyController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		String tendangnhap = req.getParameter("tendangnhap");
		String email = req.getParameter("email");
		String matkhau = req.getParameter("matkhau");
		String nhaplaimk = req.getParameter("nhaplaimk");
		String maxacnhan = req.getParameter("maxacnhan");
		String maXN = "123456";
		// Kiểm tra tên đăng nhâp
		TaiKhoanDAO tkD = new TaiKhoanDAO();
		HttpSession session = req.getSession();
		

		// Đăng kí
		if(action.equals("dangky")) {
		if(tkD.ktTK(tendangnhap)) {
			if(matkhau.equals(nhaplaimk)) {
				SendMail.sendMail(email, "Trà Sữa Online", maXN);
				TaiKhoan tk = new TaiKhoan(tendangnhap, matkhau, null, email, null, null);
				session.setAttribute("user", tk);
				res.sendRedirect(req.getContextPath() + "/test.jsp");
			}else {
				req.setAttribute("error", "Mật khẩu không trùng khớp");
				req.getRequestDispatcher("register.jsp").forward(req, res);
			}
		}else {
			req.setAttribute("error", "Tên đăng nhập đã tồn tại, vui lòng nhập tên khác");
			req.getRequestDispatcher("register.jsp").forward(req, res);
		}
		}
		
		// Xác nhận mã
		if(action.equals("maxacnhan")) {
			if(maXN.equals(maxacnhan)) {
				TaiKhoan tk = (TaiKhoan) session.getAttribute("user");
			tkD.themTaikhoan(tk);
			res.sendRedirect(req.getContextPath() + "/index.jsp");
		}else {
			req.setAttribute("error", "Mã xác nhận sai");
			req.getRequestDispatcher("test.jsp").forward(req, res);
		}
		}
		} 
	public String maXN() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return "Ma xac nhan dang nhap cua ban la:"+ "\t" + generatedString;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
