<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xác nhận mã</title>
    </head>
    <body>
        <span>Kiểm tra mail và nhập mã xác nhận</span>
        
        <form action="<%=request.getContextPath()%>/dangky?action=maxacnhan" method="post">
            <input type="text" name="maxacnhan" >
            <input type="submit" value="Xác nhận">
            <a>${error}</a>
            <a>${er}</a>
        </form>
    </body>
</html>