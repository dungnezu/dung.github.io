<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Đăng nhập" /></title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="<c:url value='/template/login/login.css' />" rel="stylesheet" type="text/css" media="all" />
</head>
<body id="LoginForm">
		<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-9" ><h5 "><a href="<c:url value='/trang-chu'/>" style="text-decoration: none; box-shadow: 0 3px tomato; padding: 4px;color: black;">Trang chủ</a></h5></div>
		</div>
		<dec:body />
</body>
</html>