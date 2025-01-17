<%@ page language="java" contentType="text/html; charset=Utf-8"
	pageEncoding="Utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/admin" var="url"></c:url>
<c:url value="/WebBanTraSua" var="path"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title>Thêm sản phẩm</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${url}/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${url}/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="${url}/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="${url}/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet" href="${url}/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="${url}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet" href="${url}/plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="${url}/plugins/daterangepicker/daterangepicker-bs3.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="${url}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="adminheader.jsp"></jsp:include>


		<jsp:include page="adminsidebar.jsp"></jsp:include>
		<div class="content-wrapper" style="margin-top: 5px;">
		<section class="content-header">
			<h3>Nhập thông tin sản phẩm</h3>
			<a>${Error}</a>
			<form class="form-horizontal"
				action="<%=request.getContextPath()%>/Quanlysanpham" method="POST">
				<div class="form-group">
					<label class="control-label col-sm-2" for="masanpham">Mã
						SP:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="masanpham"
							name="masanpham" placeholder="Nhập mã sản phẩm" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="tensanpham">Tên
						SP:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="tensanpham"
							name="tensanpham" placeholder="Nhập tên sản phẩm" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="giagiam">Hình
						ảnh:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="hinhanh"
							name="hinhanh" placeholder="Nhập hình ảnh" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="giaban">Giá bán:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="giaban" name="giaban"
							placeholder="Nhập giá bán" required/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success">Thêm sản
							phẩm</button>
					</div>
				</div>

			</form>
			</section>
		</div>
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 1.9.9
			</div>
			<strong>Copyright &copy; 2010-2020 <a
				href="http://facebook.com">AnonKing Studio</a>.
			</strong> All rights reserved.
		</footer>
	</div>
	<!-- jQuery 2.2.0 -->
	<script src="${url}/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.6 -->
	<script src="${url}/bootstrap/js/bootstrap.min.js"></script>
	<!-- Morris.js charts -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="${url}/plugins/morris/morris.min.js"></script>
	<!-- Sparkline -->
	<script src="${url}/plugins/sparkline/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script src="${url}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${url}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="${url}/plugins/knob/jquery.knob.js"></script>
	<!-- daterangepicker -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
	<script src="${url}/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- datepicker -->
	<script src="${url}/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script
		src="${url}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script src="${url}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="${url}/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="${url}/dist/js/app.min.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="${url}/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
</body>
</html>