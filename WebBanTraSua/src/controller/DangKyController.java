package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SanPhamDAO;
import dao.TaiKhoanDAO;
import mail.SendMail;
import model.SanPham;
import model.TaiKhoan;
import sun.security.krb5.internal.tools.Ktab;


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
		String hovaten =  req.getParameter("hovaten");
		String sdt =  req.getParameter("sdt");
		// Kiểm tra tên đăng nhâp
		TaiKhoanDAO tkD = new TaiKhoanDAO();
		SendMail mail = new SendMail();
		Random rd = new Random();
		int maxacnhan = rd.nextInt();
		// Đăng kí
		if(action.equals("dangky")) {
		if(tkD.ktTK(tendangnhap)) {
			if(matkhau.equals(nhaplaimk)) {
				mail.sendMail(email, "Trà Sữa Online", givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect());
				String inputma = "<input class=\"input100\" type=\"text\" name=\"maxn\"placeholder=\"Mã xác nhận\"  title=\"Vui lòng kiểm tra email để lấy mã xác nhận\"></input>";
				req.setAttribute("maxn", inputma);
				req.setAttribute("tb", "Hãy kiểm tra email để lấy mã xác nhận");
				req.getRequestDispatcher("register.jsp").forward(req, res);
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
		if(action.equals("xacnhanma")) {
			TaiKhoan tk = new TaiKhoan(tendangnhap, matkhau, null, null, email, null);
			tkD.themTaikhoan(tk);
		}

		}
//	private String Random() {
//		Random rd = new Random();
//		int[] nums = new int[10];
//		 for (int i = 0; i < nums.length; ++i){
//	            nums[i] = rd.nextInt(10);
//	        }
//		return null;
//	}
	public String givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
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
