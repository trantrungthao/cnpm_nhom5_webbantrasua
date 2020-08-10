package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.TaiKhoan;

//Sau khi chọn tài khoản để đăng nhập, google sẽ gửi một đoạn mã (code) tới url “https://localhost:8443/WebBanTraSua/google” để server xử lý.
@WebServlet("/google")
public class GoogleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Dùng để lưu client_id, client_secret, redirect_uri của ứng dung Google
	private static String GOOGLE_CLIENT_ID = "788574466020-k3ifc49gl8efn3hq4ebu5s9o5jf7ako5.apps.googleusercontent.com";
	private static String GOOGLE_CLIENT_SECRET = "d-SrCN3Za0bmDd5KoYtX8mJD";
	private static String GOOGLE_REDIRECT_URI = "https://localhost:8443/WebBanTraSua/google";
	private static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	private static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	private static String GOOGLE_GRANT_TYPE = "authorization_code";

	public GoogleController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Nhận code google gửi về
		String code = req.getParameter("code");
		// Kiểm tra nếu mã code google
		if (code == null || code.isEmpty()) {
			req.getRequestDispatcher("dangnhap.jsp").forward(req, res);
		} else {
			// Đổi mã code thành access-token
			String accessToken = getToken(code);
			// Dùng access-token để truy cập các thông tin trong tài khoản google như email,
			// name, id
			TaiKhoanGoogle googlePojo = getUserInfo(accessToken);
			// Lấy tra tên email
			TaiKhoan tk = new TaiKhoan(googlePojo.getEmail(), null, null, null, null, null);
			// Tạo 1 phiện làm việc để lưu lại trạng thái đăng nhập
			HttpSession session = req.getSession();
			session.setAttribute("tk", tk);
			// Chuyển hướng qua trang chủ
			req.getRequestDispatcher("trangchu.jsp").forward(req, res);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// dùng để gửi truy vấn tới google đổi code sang access-token
	private String getToken(String code) throws ClientProtocolException, IOException {
		// Gửi request từ bên trong class servlet
		String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID).add("client_secret", GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", GOOGLE_REDIRECT_URI).add("code", code).add("grant_type", GOOGLE_GRANT_TYPE)
						.build())
				.execute().returnContent().asString();
		// Dùng thư viện gson để convert dữ liệu từ dạng json và ngược lại
		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

	// Lấy thông tin trong tài khoản google
	private TaiKhoanGoogle getUserInfo(String accessToken) throws ClientProtocolException, IOException {
		// Gửi request từ bên trong class servlet
		String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
		// Dùng thư viện gson để convert dữ liệu từ dạng json và ngược lại
		TaiKhoanGoogle TKG = new Gson().fromJson(response, TaiKhoanGoogle.class);
//		System.out.println(TKG.getFamily_name()+" "+TKG.getLink()+" "+TKG.getPicture()+" "+TKG.getGiven_name());
		return TKG;
	}

	// Gồm các thuộc tính tương ứng với các thông tin trong tài khoản google trả về
	public class TaiKhoanGoogle {
		// id tài khoản
		private String id;
		// Email tài khoản
		private String email;
		// Email xác minh
		private boolean verified_email;
		// Tên tài khoản
		private String name;
		// Tên
		private String given_name;
		// Biệt danh
		private String family_name;
		// Link tài khoản
		private String link;
		// Link hình ảnh
		private String picture;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public boolean isVerified_email() {
			return verified_email;
		}

		public void setVerified_email(boolean verified_email) {
			this.verified_email = verified_email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGiven_name() {
			return given_name;
		}

		public void setGiven_name(String given_name) {
			this.given_name = given_name;
		}

		public String getFamily_name() {
			return family_name;
		}

		public void setFamily_name(String family_name) {
			this.family_name = family_name;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getPicture() {
			return picture;
		}

		public void setPicture(String picture) {
			this.picture = picture;
		}

	}
}
