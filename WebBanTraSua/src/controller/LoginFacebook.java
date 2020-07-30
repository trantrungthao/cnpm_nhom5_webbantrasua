package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.types.User;

import model.Facebook;


@WebServlet("/login-facebook")
public class LoginFacebook extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LoginFacebook() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    
    if (code == null || code.isEmpty()) {
      RequestDispatcher dis = request.getRequestDispatcher("facebook.jsp");
      dis.forward(request, response);
    } else {
      String accessToken = Facebook.getToken(code);
      User user = Facebook.getUserInfo(accessToken);
      request.setAttribute("id", user.getId());
      request.setAttribute("name", user.getName());
      RequestDispatcher dis = request.getRequestDispatcher("indextest.jsp");
      dis.forward(request, response);
    }
    
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
