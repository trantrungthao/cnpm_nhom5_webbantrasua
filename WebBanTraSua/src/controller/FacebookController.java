package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/facebook")
public class FacebookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String FACEBOOK_APP_ID = "736929813734347";
	public static String FACEBOOK_APP_SECRET = "fa7edbcafc081c673039501f562df925";
	public static String FACEBOOK_REDIRECT_URL = "http://localhost:8080/WebBanTraSua/facebook";
	public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";

	public FacebookController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String code = req.getParameter("code");

		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = req.getRequestDispatcher("dangnhap.jsp");
			dis.forward(req, res);
		} else {
		      String accessToken = RestFB.getToken(code);
		      User user = RestFB.getUserInfo(accessToken);
			  TaiKhoan tk = new TaiKhoan(user.getName(), null, null, null, null, null);
		      HttpSession session = req.getSession();
		      session.setAttribute("tk", tk);
			RequestDispatcher dis = req.getRequestDispatcher("trangchu.jsp");
			dis.forward(req, res);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	public static class RestFB {
		  
		  public static String getToken(final String code) throws ClientProtocolException, IOException {
		    String link = String.format(FACEBOOK_LINK_GET_TOKEN, FACEBOOK_APP_ID, FACEBOOK_APP_SECRET, FACEBOOK_REDIRECT_URL, code);
		    String response = Request.Get(link).execute().returnContent().asString();
		    JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		    String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		    return accessToken;
		  }
		  
		  public static User getUserInfo(String accessToken) {
		    FacebookClient facebookClient = new DefaultFacebookClient(accessToken, FACEBOOK_APP_SECRET, Version.LATEST);
		    return facebookClient.fetchObject("me", User.class);
		  }
		}
	
	
}
