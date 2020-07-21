<%@page import="java.sql.ResultSet"%>
<%@page import="model.ConnectToDatabase"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/admin" var="url"></c:url>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="adminheader.jsp"></jsp:include>


		<jsp:include page="adminsidebar.jsp"></jsp:include>

		<div class="content-wrapper" style="margin-top: 5px;">
			<section class="content-header">
				<h3>
					Quản lý sản phẩm
				</h3>
				<div class="row"> 
			<div class="col-md-12"> 
						<a href="adminaddSanPham.jsp"><button class="btn btn-success">Thêm tài khoản</button></a>
				<div class="panel panel-primary"> 
					<div class="panel-heading"> 
						<h3 class="panel-title">Danh sách thành viên</h3> 
						
					</div> 
					<div class="panel-body"> <input class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Từ khóa" type="text"> 
					</div> 
					
					<%
					ConnectToDatabase con = new ConnectToDatabase();
					ResultSet rs = con.selectData("select * from Sanpham");
					
					%>
					<table class="table table-hover" id="dev-table"> 
						<thead> 
							<tr> 
								<th>STT</th> 
								<th>Mã SP</th> 
								<th>Tên SP</th> 
								<th>Giá giảm</th> 
								<th>Giá bán</th>
								<th>Số lượng</th> 
								<th>Nhà cung cấp</th> 
								<th>Mã loại</th> 
								<th>Hình ảnh</th> 
								<th>Số lượng nhập</th> 
								<th>Số lượng bán</th> 
								<th>Xóa</th>
								<th>Sửa</th>
							</tr> 
						</thead> 
						<tbody>
						<%int count=0;
						while(rs.next()){count++;
						%>
						
						<tr> 
							<td><%=count %></td> 
							<td><%=rs.getString(1) %></td> 
							<td><%=rs.getString(2) %></td> 
							<td><%=rs.getString(3) %></td> 
							<td><%=rs.getString(4) %></td>
							<td><%=rs.getString(5) %></td> 
							<td><%=rs.getString(6) %></td>
							<td><%=rs.getString(7) %></td> 
							<td><%=rs.getString(8) %></td> 
							<td><%=rs.getString(9) %></td> 
							<td><%=rs.getString(10) %></td> 
							<td><a href="ThemSuaXoaSP?id=<%=rs.getString(1)%>&chucNang=Xoa"><button class="btn btn-warning">Xóa</button></a></td>
							<td><a href="admineditSanPham.jsp?id=<%=rs.getString(1)%>&chucNang=Sua"><button class="btn btn-primary">Sửa</button></a></td>
						</tr> 
						<%
						}
						%>
						
					</tbody></table> 
				</div> 
			</div> 
		</div>
			</section>
		</div>
		
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.3.3
			</div>
			<strong>Copyright &copy; 2014-2015 <a
				href="http://facebook.com">AnonKing Studio</a>.
			</strong> All rights reserved.
		</footer>
	</div>
	<!-- ./wrapper -->

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
