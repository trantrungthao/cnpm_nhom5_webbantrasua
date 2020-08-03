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
		String tendangnhap = req.getParameter("tendangnhap");
		String email = req.getParameter("email");
		String matkhau = req.getParameter("matkhau");
		String nhaplaimk = req.getParameter("nhaplaimk");
		if(matkhau != nhaplaimk) {
			req.setAttribute("error", "Mật khẩu không trùng khớp");
			req.getRequestDispatcher("register.jsp").forward(req, res);
		} else {
			
		}
		
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
