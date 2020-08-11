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
import model.Captcha;
import model.TaiKhoan;

// Mapping: Gọi servlet xử lý từ trang dangnhap.jsp
@WebServlet("/Dangnhap")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Constructor
	public DangNhapController() {
		super();
	}

	// doPost đóng gói dữ liệu lại và gửi đi
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Nhận vào action để xử lý
		String action = req.getParameter("action");
		// Nhận input tendangnhan của người dùng nhập vào
		String tendangnhap = req.getParameter("tendangnhap");
		// Nhận input matkhau của người dùng nhập vào
		String matkhau = req.getParameter("matkhau");

		// Tạo 1 phiên làm việc lưu lại trạng thái người dùng
		HttpSession session = req.getSession();

		// Xử lý đăng nhập action=dangnhap
		if (action.equals("dangnhap")) {
			TaiKhoanDAO TKD = new TaiKhoanDAO();
			// Lấy danh sách tài khoản trong database
			Map<String, TaiKhoan> listTK = TKD.loadData();
			// Kiểm tra tên đăng nhập và mật khẩu
			if (TKD.checkLogin(tendangnhap, matkhau)) {
				// Kiểm tra quyền admin
				if (TKD.checkAdmin(tendangnhap, "admin")) {
					// Lấy ra tài khoản trong listTK và lưu vào session
					TaiKhoan tk = listTK.get(tendangnhap);
					session.setAttribute("tk", tk);
					// Chuyển hướng qua trang admin
					res.sendRedirect(req.getContextPath() + "/admin/adminindex.jsp");
				} else {
					// Lấy ra tài khoản trong listTK và lưu vào session
					TaiKhoan tk = listTK.get(tendangnhap);
					session.setAttribute("tk", tk);
					// Chuyển hướng qua trang chủ
					res.sendRedirect("trangchu.jsp");
				}
			} else {
				// Biến đếm số lần đăng nhập sai
				int count = 0;
				// Kiểm tra trạng thái đăng nhập sai trong session
				if(session.getAttribute("solandn")!=null) {
					// Nếu có thì lấy ra count và tăng lên 1
					count= (int) session.getAttribute("solandn");
				}
				count++;
				// Đăng nhập sai 3 lần thì chuyển qua trang captcha
				if(count>2) {
					// Hủy session của đối tượng số lần đăng nhập
					session.removeAttribute("solandn");
					count=0;
					// Chuyển hướng qua trang xác nhận captcha
					res.sendRedirect("captcha.jsp");
				}else {
				// Lưu lại trang thái đăng nhập sai	
				session.setAttribute("solandn", count);
				// Hiện thông báo ra trang đăng nhập
				req.setAttribute("error", "  *Tài khoản hoặc mật khẩu không đúng");
				// Chuyển tiếp về trang đăng nhập
				req.getRequestDispatcher("dangnhap.jsp").forward(req, res);
				}
			}
		}
		// Xử lý đăng xuất nếu action=dangxuat
		if (action.equals("dangxuat")) {
			// Hủy phiên làm việc của người dùng
			session.invalidate();
			// Chuyển hướng qua trang chủ
			res.sendRedirect("trangchu.jsp");
		}
		// Xử lý nhập captcha nếu action=captcha
		if (action.equals("captcha")) {
			// Nhận chuỗi captcha đã xác nhận từ trang captcha.jsp
			String gRecaptchaResponse = req.getParameter("g-recaptcha-response");
			// Kiểm tra chuỗi captcha
			boolean verify = Captcha.verify(gRecaptchaResponse);
			// Nếu trùng (true)
			if (verify) {
				// Chuyển hướng qua trang đăng nhập
				res.sendRedirect("dangnhap.jsp");
			} else {
				// Hiện thông báo lỗi ra trang
				req.setAttribute("error", "  *Vui lòng xác nhận captcha");
				// Chuyển tiếp lại trang xác nhận captcha
				req.getRequestDispatcher("captcha.jsp").forward(req, res);
			}
		}
	}
	
	// doGet tạo một chuỗi xuất hiện trong hộp địa chỉ URL của trình duyệt và gửi đi
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
