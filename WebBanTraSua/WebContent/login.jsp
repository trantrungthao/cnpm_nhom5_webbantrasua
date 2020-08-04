<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Đăng nhập</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="khachhang/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="khachhang/css/util.css">
	<link rel="stylesheet" type="text/css" href="khachhang/css/main.css">
<!--===============================================================================================-->
<!-- API captcha google -->
<script src="https://www.google.com/recaptcha/api.js"></script>

<!-- Đăng nhập bằng google -->
	<meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="788574466020-k3ifc49gl8efn3hq4ebu5s9o5jf7ako5.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" aync defer></script>
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="khachhang\img\ts\logodn.png" alt="IMG">
				</div>

				<form action="<%=request.getContextPath()%>/dangnhap" method="POST" class="login100-form validate-form">
					<span class="login100-form-title">
						ĐĂNG NHẬP
					</span>
					<!--Hiện thông báo đăng nhập không thành công-->
					<a>${error}</a>	
					<div class="wrap-input100 validate-input">
						<!-- Kiểm tra trường dữ liệu không để trống và nhận vào userName-->
						<input class="input100" type="text" name="username" placeholder="Tên đăng nhập" required/>
					</div>

					<div class="wrap-input100 validate-input" >
						<!--Kiểm tra password đủ 6 kí tự trở lên và nhận vào password-->
						<input class="input100" type="password" name="password" placeholder="Mật khẩu" pattern=".{6,}"
              title="6 kí tự trở lên" required/>
					</div>
					<a>${captcha}</a>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">
							Đăng nhập
						</button>
					</div>
				<!--  
					<div class="fb-login-button" data-size="large" data-button-type="login_with" data-layout="default" data-auto-logout-link="false" data-use-continue-as="false" data-width=""></div>
					<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
				-->		
					<div class="text-center p-t-12">
						<span class="txt1">
							Quên
						</span>
						<a class="txt2" href="#">
							Tên đăng nhập / Mật khẩu?
						</a>
					</div>
					<div class="text-center p-t-136">
						<a class="txt2" href="khachhang/register.html">
							Đăng kí tài khoản
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v7.0&appId=736929813734347&autoLogAppEvents=1" nonce="8ET0v11E"></script>
	

	<script>
      function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      }
    </script>
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="khachhang/js/main.js"></script>

</body>
</html>