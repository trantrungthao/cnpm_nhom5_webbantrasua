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
		//kiểm tra đăng ký
		String action = req.getParameter("action");
		String tendangnhap = req.getParameter("tendangnhap");
		String email = req.getParameter("email");
		String matkhau = req.getParameter("matkhau");
		String nhaplaimk = req.getParameter("nhaplaimk");
		String maxacnhan = req.getParameter("maxacnhan");
		TaiKhoanDAO tkD = new TaiKhoanDAO();
		//lưu lại 1 phiên đăng ký
		HttpSession session = req.getSession();
		

		// Đăng kí
		if(action.equals("dangky")) {
			//kiểm tra trùng tên đăng ký
		if(tkD.ktTK(tendangnhap)) {
			//kiểm tra nhập lại mật khẩu có trùng khớp với mật khẩu không
			if(matkhau.equals(nhaplaimk)) {
				//tạo một mã random
				String maXN = maXN();
				//nếu không trùng tên và mật khẩu trùng khớp thì gửi mã random tới email đã nhập
				SendMail.sendMail(email, "Trà Sữa Online", "Mã xác nhận của bạn là: " + maXN);
				TaiKhoan tk = new TaiKhoan(tendangnhap, matkhau, null, email, null, null);
				//ghi nhớ các trường đã nhập khi đăng ký
				session.setAttribute("user", tk);
				//lưu lại mã xác nhận khi đăng ký
				session.setAttribute("ma", maXN);
				//chuyển qua trang nhập mã xác nhận
				res.sendRedirect(req.getContextPath() + "/xacnhan.jsp");
			}else {
				req.setAttribute("error", "Mật khẩu không trùng khớp");
				req.getRequestDispatcher("dangky.jsp").forward(req, res);
			}
		}else {
			req.setAttribute("error", "Tên đăng nhập đã tồn tại, vui lòng nhập tên khác");
			req.getRequestDispatcher("dangky.jsp").forward(req, res);
		}
		}
		
		// Xác nhận mã
		if(action.equals("maxacnhan")) {
			//lấy mã xác nhận đã lưu ở session trên
			String ma = (String) session.getAttribute("ma");
			//kiểm tra xem mã nhập vào có trùng với mã được nhận không
			if(ma.equals(maxacnhan)) {
				TaiKhoan tk = (TaiKhoan) session.getAttribute("user");
				//nếu trùng thì thêm tài khoản vào cơ sở dữ liệu
			tkD.themTaikhoan(tk);
			res.sendRedirect(req.getContextPath() + "/trangchu.jsp");
		}else {
			req.setAttribute("error", "Mã xác nhận sai");
			req.getRequestDispatcher("xacnhan.jsp").forward(req, res);
		}
		}
		} 
	//hàm tạo chuỗi random em lấy trên mạng
	public static String maXN() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    return generatedString;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
