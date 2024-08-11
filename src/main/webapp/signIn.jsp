<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý học sinh</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@v5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/registration.css">
	
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400..900;1,400..900&display=swap" rel="stylesheet">

</head>
<body>
	<div class="main">
		<h1 class="app-name" style="font-family: 'Playfair Display', serif;">QUẢN LÝ HỌC SINH</h1>

		<img src="./image/bg.jpg" alt="" class="background-img">
		<form action="<%=request.getContextPath()%>/SignIn" method="POST"
			class="form" id="sign-in-form">
			<h3 class="heading">Đăng nhập</h3>

			<div class="spacer"></div>

			<div class="form-group">
				<i class="user-icon fa-solid fa-user"></i> <input id="username"
					name="username" rules="required" type="text"
					placeholder="Tên đăng nhập" class="form-control">
				<div></div>
				<span class="form-message"></span>
			</div>

			<div class="form-group">
				<i class="key-icon fa-solid fa-key"></i> <input id="password"
					name="password" rules="required|min:8" type="password"
					placeholder="Mật khẩu" class="form-control"> <span
					class="form-message"></span>
			</div>
			<c:if test="${not empty requestScope.messageerror}">
				<div class="alert alert-error" style="color: red;">${requestScope.messageerror}</div>
			</c:if>

			<input class="form-submit sign-in" type="submit" value="Đăng nhập" />
			<a href="" class="forgot-password">Quên mật khẩu?</a>

		</form>

	</div>


</body>
</html>