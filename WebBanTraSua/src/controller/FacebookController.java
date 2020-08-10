package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

import model.TaiKhoan;

// Dùng thư viện restfb để truy vấn thông tin với facebook api,
// Dùng thư viện org.apache.httpcomponents (httpclient, httpcore, fluent) để gửi request tới facebook
// Thư viện gson để convert dữ liệu từ dạng json và ngược lại.
// Sau khi chọn tài khoản để đăng nhập, facebook sẽ gửi một đoạn mã (code) tới url “https://localhost:8443/WebBanTraSua/facebook” để server xử lý.
@WebServlet("/facebook")
public class FacebookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Dùng để khai báo id, secret và redirect uri của ứng dụng Facebook
	private static String FACEBOOK_APP_ID = "736929813734347";
	private static String FACEBOOK_APP_SECRET = "fa7edbcafc081c673039501f562df925";
	private static String FACEBOOK_REDIRECT_URL = "https://localhost:8443/WebBanTraSua/facebook";
	private static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";

	// Constructor
	public FacebookController() {
		super();
	}
	//
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Nhận code facebook gửi về
		String code = req.getParameter("code");
		// Kiểm tra code
		if (code == null || code.isEmpty()) {
			// Chuyển tiếp về trang đăng nhập
			req.getRequestDispatcher("dangnhap.jsp").forward(req, res);
		} else {
			// Đổi mã code thành access-token
			String accessToken = getToken(code);
			// Dùng access-token để truy cập các thông tin trong tài khoản
			User user = getUserInfo(accessToken);
			// Lưu lại tên tài khoản
			TaiKhoan tk = new TaiKhoan(user.getName(), null, null, null, null, null);
			// Tạo 1 phiện làm việc để lưu lại trạng thái đăng nhập
			HttpSession session = req.getSession();
			session.setAttribute("tk", tk);
			// Chuyển hướng đến trang chủ
			req.getRequestDispatcher("trangchu.jsp").forward(req, res);
		}

	}
	//
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	// Dùng để truy vấn tới facebook đổi code lấy access token
	private String getToken(String code) throws ClientProtocolException, IOException {
		String link = String.format(FACEBOOK_LINK_GET_TOKEN, FACEBOOK_APP_ID, FACEBOOK_APP_SECRET,
				FACEBOOK_REDIRECT_URL, code);
		String response = Request.Get(link).execute().returnContent().asString();
		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}
	// Dùng để lấy thông tin tài khoản facebook
	private User getUserInfo(String maToken) {
		FacebookClient facebookClient = new DefaultFacebookClient(maToken, FACEBOOK_APP_SECRET, Version.LATEST);
		return facebookClient.fetchObject("me", User.class);
	}

}
