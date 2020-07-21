<%@page import="model.ConnectToDatabase"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%ServletContext contextChucNang = getServletContext();
    	contextChucNang.setAttribute("chucNang", "Sua");
    	ServletContext contextID = getServletContext();
    	contextID.setAttribute("id", request.getParameter("id"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
  <h2>Sửa thông tin sản phẩm</h2>
  <%String id = request.getParameter("id");
  		ResultSet rs = new ConnectToDatabase().prepareStatement("select * from Sanpham where Masanpham='"+id+"'");
  		while(rs.next()){
  %>
  <form class="form-horizontal" action="ThemSuaXoaSP" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="masanpham">Mã SP:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="masanpham" name="masanpham" placeholder="Nhập mã sản phẩm" value="<%
        		out.print(rs.getString(1));
        %>">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="tensanpham">Tên SP:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="tensanpham" name="tensanpham" placeholder="Nhập tên sản phẩm" value="<%
        	out.print(rs.getString(2));%>">
      </div>
    </div>
    	<div class="form-group">
      <label class="control-label col-sm-2" for="giagiam">Giá đã giảm:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="giagiam" name="giagiam" placeholder="Nhập đã giảm" value="<%
        	 	 out.print(rs.getString(3));
        %>">
      </div>
    </div>
  <div class="form-group">
      <label class="control-label col-sm-2" for="giaban">Giá bán:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="giaban" name="giaban" placeholder="Nhập giá bán" value="<%
        	 	 out.print(rs.getString(4));
        %>">
      </div>
    </div>

	<div class="form-group">
      <label class="control-label col-sm-2" for="soluong">Số lượng:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="soluong" name="soluong" placeholder="Nhập số lượng" value="<%
        	 	 out.print(rs.getString(5));
        %>">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" for="nhacungcap">Nhà cung cấp:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="nhacungcap" name="nhacungcap" placeholder="Nhập nhà cung cấp" value="<%
        	 	 out.print(rs.getString(6));
        %>">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="maloai">Mã loại:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="maloai" name="maloai" placeholder="Nhập mã loại" value="<%
        	 	 out.print(rs.getString(7));
        %>">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="soluongnhap">Số lượng nhập:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="soluongnhap" name="soluongnhap" placeholder="Nhập lượng nhập" value="<%
        	 	 out.print(rs.getString(9));
        %>">
      </div>
    </div>
       <div class="form-group">
      <label class="control-label col-sm-2" for="soluongban">Số lượng bán:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="soluongban" name="soluongban" placeholder="Nhập lượng bán" value="<%
        	 	 out.print(rs.getString(10));
        %>">
      </div>
    </div>
  
	
    <%} %>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Sửa</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>