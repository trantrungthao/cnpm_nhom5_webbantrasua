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
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.TaiKhoan;

@WebServlet("/google")
public class GoogleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String GOOGLE_CLIENT_ID = "788574466020-k3ifc49gl8efn3hq4ebu5s9o5jf7ako5.apps.googleusercontent.com";
	  public static String GOOGLE_CLIENT_SECRET = "d-SrCN3Za0bmDd5KoYtX8mJD";
	  public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/WebBanTraSua/google";
	  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	  public static String GOOGLE_GRANT_TYPE = "authorization_code";
	  public GoogleController() {
		    super();
		  }
	  protected void doGet(HttpServletRequest req, HttpServletResponse res)
		      throws ServletException, IOException {
		    String code = req.getParameter("code");
		    if (code == null || code.isEmpty()) {
		      RequestDispatcher dis = req.getRequestDispatcher("dangnhap.jsp");
		      dis.forward(req, res);
		    } else {
		      String accessToken = GoogleUtils.getToken(code);
		      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
		      TaiKhoan tk = new TaiKhoan(googlePojo.getEmail(), null, null, null, null, null);
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
		  public static class GoogleUtils {
			  public static String getToken(final String code) throws ClientProtocolException, IOException {
			    String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
			        .bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID)
			            .add("client_secret", GOOGLE_CLIENT_SECRET)
			            .add("redirect_uri",GOOGLE_REDIRECT_URI).add("code", code)
			            .add("grant_type", GOOGLE_GRANT_TYPE).build())
			        .execute().returnContent().asString();
			      JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
			      String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
			      return accessToken;
			  }
			  public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
			    String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
			    String response = Request.Get(link).execute().returnContent().asString();
			    GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
			    System.out.println(googlePojo);
			    return googlePojo;
			  }
			}
		  public class GooglePojo {
				private String id;
				private String email;
				private boolean verified_email;
				private String name;
				private String given_name;
				private String family_name;
				private String link;
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
