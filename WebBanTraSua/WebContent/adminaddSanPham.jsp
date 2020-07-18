<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
        <%ServletContext contextChucNang = getServletContext();
    	contextChucNang.setAttribute("chucNang", "Them");
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
            var loadFile = function (event) {
                var reader = new FileReader();
                reader.onload = function () {
                    var output = document.getElementById('output');
                    output.src = reader.result;
                };
                reader.readAsDataURL(event.target.files[0]);
            };// code display image upload
        </script>
</head>
<body>
	<div class="container">
  <h2>Thêm thông tin tài khoản khách hàng</h2>
  <form class="form-horizontal" action="ThemSuaXoaSP" method="post">
  	<div class="form-group">
      <label class="control-label col-sm-2" for="masanpham">Mã SP:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="masanpham" name="masanpham" placeholder="Nhập họ mã sản phẩm">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="tensanpham">Tên SP:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="tensanpham" name="tensanpham" placeholder="Nhập họ tên">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="giagiam">Giá đã giảm:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="giagiam" name="giagiam" placeholder="Nhập giá giảm" >
      </div>
    </div>
  <div class="form-group">
      <label class="control-label col-sm-2" for="giaban">Giá bán:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="giaban" name="giaban" placeholder="Nhập giá bán" >
      </div>
    </div>
	 <div class="form-group">
      <label class="control-label col-sm-2" for="soluong">Số lượng:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="soluong" name="soluong" placeholder="Nhập số lượng" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="nhacungcap">Nhà cung cấp:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="nhacungcap" name="nhacungcap" placeholder="Nhập nhà cung cấp">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="maloai">Mã loại:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="maloai" name="maloai" placeholder="Nhập mã loại" >
      </div>
    </div> 
    <div class="form-group">
      <label class="control-label col-sm-2" for="photo">Hình ảnh:</label>
      <div class="col-sm-10">
      <!-- accept="image/*" cho phép up ảnh với tất cả các đuôi-->
        <input type="file" class="form-control" id="photo" name="photo" accept="image/*" onchange="loadFile(event)">
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="soluongnhap">Số lượng nhập:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="soluongnhap" name="soluongnhap" placeholder="Nhập lượng nhập">
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="soluongban">Số lượng bán:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="soluongban" name="soluongban" placeholder="Nhập lượng bán">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Thêm</button>
      </div>
    </div>
    
    
	
  </form>
</div>
</body>
</html>