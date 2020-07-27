<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/admin" var="url"></c:url>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
 	<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="${url}/dist/img/avatar5.png" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						<p></p>
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				<!-- search form -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Tìm kiếm..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">

					<li><a
						href="#"> <i
							class="fa fa-th"></i> <span>Quản lý khách hàng</span>

					</a></li>

					<li class="treeview"><a href="<%=request.getContextPath()%>/Quanlysanpham" > <i class="fa fa-th"></i>
							<span>Quản lý sản phẩm</span> 
					</a>
						</li>

					<li class="treeview"><a href="#"> <i class="fa fa-th"></i>
							<span>Quản lý hóa đơn</span>
							
					</a>
						</li>
					
					<li><a href="#"> <i
							class="fa fa-envelope"></i> <span>Quản lý hộp thư</span> <small
							class="label pull-right bg-yellow">9</small>
					</a></li>


					<li class="treeview"><a href="#"> <i
							class="fa fa-pie-chart"></i> <span>Thống kê</span>
					</a>
						</li>

				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>
 
<!-- ./wrapper -->


<!-- AdminLTE for demo purposes -->
</body>
</html>