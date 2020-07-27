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

					<div class="wrap-input100 validate-input">
						<!-- Kiểm tra trường dữ liệu không để trống và nhận vào userName-->
						<input class="input100" type="text" name="username" placeholder="Tên đăng nhập" required/>
					</div>

					<div class="wrap-input100 validate-input" >
						<!--Kiểm tra password đủ 6 kí tự trở lên và nhận vào password-->
						<input class="input100" type="password" name="password" placeholder="Mật khẩu" pattern=".{6,}"
              title="6 kí tự trở lên" required/>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">
							Đăng nhập
						</button>
					</div>
					<!--Hiện thông báo đăng nhập không thành công-->
					<p>${error}</p>	
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