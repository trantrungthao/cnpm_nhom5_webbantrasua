package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangDAO;
import model.TaiKhoan;


@WebServlet(urlPatterns = { "/dangnhap" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		
		KhachHangDAO kh = new KhachHangDAO();
		if (kh.checkLogin(userName, passWord)&&"admin".equals(KhachHangDAO.mapTaiKhoan.get(userName).getRole())) {
			res.sendRedirect(req.getContextPath() + "/admin/adminindex.jsp");
		} else {
			if (kh.checkLogin(userName, passWord)) {
				HttpSession session = req.getSession();
				TaiKhoan tk = KhachHangDAO.mapTaiKhoan.get(userName);
				session.setAttribute("userlogin", tk);
				res.sendRedirect(req.getContextPath() +"/index.jsp");
			} else {
					req.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
					req.getRequestDispatcher("login.jsp").forward(req, res);
				}
				
			}
	
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
