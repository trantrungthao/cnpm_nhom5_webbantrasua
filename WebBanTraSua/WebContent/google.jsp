<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<body>
  <h1>login google</h1>
  <!-- Đường link https://accounts.google.com/o/oauth2/...force dùng để gọi hộp thoại đăng nhập và cài đặt URL chuyển hướng -->
  <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/WebBanTraSua/login-google&response_type=code
    &client_id=788574466020-k3ifc49gl8efn3hq4ebu5s9o5jf7ako5.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
</body>
</html>