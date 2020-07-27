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

<header class="main-header">
			<!-- Logo -->
			<a href="adminindex.jsp" class="logo">
				<span class="logo-mini"><b>A</b>D</span>
				<span class="logo-lg"><b>Admin</b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>
<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu"><a href="<%=request.getContextPath()%>/index.jsp">QUAY LẠI SHOP</a>
							</li>
					</ul>
				</div>
			</nav>
		</header>

</body>
</html>