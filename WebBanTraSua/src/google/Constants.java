package google;

// Dùng để lưu client_id, client_secret, redirect_uri của ứng dung JSPServet Google
public class Constants {
	public static String GOOGLE_CLIENT_ID = "788574466020-k3ifc49gl8efn3hq4ebu5s9o5jf7ako5.apps.googleusercontent.com";
	  public static String GOOGLE_CLIENT_SECRET = "d-SrCN3Za0bmDd5KoYtX8mJD";
	  public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/WebBanTraSua/login-google";
	  //Đường link https://accounts.google.com/o/oauth2/...force dùng để gọi hộp thoại đăng nhập và cài đặt URL chuyển hướng
	  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	  public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
