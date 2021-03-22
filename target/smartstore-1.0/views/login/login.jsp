<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<c:if test="${not empty message}">
				<div class="alert alert-${alert}">${message}</div>
			</c:if>
			<!-- Icon -->
			<div class="fadeIn first">
				<h3>Đăng nhập</h3>
			</div>

			<!-- Login Form -->
			<form action="<c:url value='/dang-nhap'/>" id="formLogin"
				method="post">
				<input type="text" id="username" class="fadeIn second"
					name="username" placeholder="Tên đăng nhập"> <input
					type="password" id="password" class="fadeIn third" name="password"
					placeholder="Mật khẩu"> <input type="hidden" value="login"
					name="action">
				<button type="submit" class="btn btn-primary">Đăng nhập</button>

			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				
			</div>

		</div>
	</div>
</body>
</html>