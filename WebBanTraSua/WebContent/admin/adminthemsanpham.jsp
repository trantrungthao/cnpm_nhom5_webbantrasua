<%@ page language="java" contentType="text/html; charset=Utf-8"
	pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Thêm thông tin tài khoản khách hàng</h2>
		<form class="form-horizontal" action="<%=request.getContextPath()%>/Quanlysanpham" method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2" for="masanpham">Mã SP:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="masanpham"
						name="masanpham" placeholder="Nhập mã sản phẩm">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="tensanpham">Tên
					SP:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="tensanpham"
						name="tensanpham" placeholder="Nhập tên sản phẩm">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="giagiam">Hình
					ảnh:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="hinhanh" name="hinhanh"
						placeholder="Nhập hình ảnh">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="giaban">Giá bán:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="giaban" name="giaban"
						placeholder="Nhập giá bán">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Thêm sản
						phẩm</button>
				</div>
			</div>

		</form>
	</div>
</body>
</html>