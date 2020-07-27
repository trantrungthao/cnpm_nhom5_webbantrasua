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


@WebServlet(urlPatterns = { "/dangnhap" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		
		TaiKhoanDAO kh = new TaiKhoanDAO();
		Map<String, TaiKhoan> listTK = kh.loadData();
		if (kh.checkLogin(userName, passWord)&&kh.checkAdmin(userName, "admin")) {
			HttpSession session = req.getSession();
			TaiKhoan tk = listTK.get(userName);
			session.setAttribute("user", tk);
			res.sendRedirect(req.getContextPath() + "/admin/adminindex.jsp");
		} else {
			if (kh.checkLogin(userName, passWord)) {
				HttpSession session = req.getSession();
				TaiKhoan tk = listTK.get(userName);
				session.setAttribute("user", tk);
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
