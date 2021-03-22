<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><dec:title default="Trang chủ" /></title>

    <!-- Google Font -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/font-awesome.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/elegant-icons.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/nice-select.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/jquery-ui.min.css' />" type="text/css">
    
    <link rel="stylesheet" href="<c:url value='/template/web/css/slicknav.min.css' />" type="text/css">

    <link rel="stylesheet" href="<c:url value='/template/web/sass/style.css' />" type="text/css"> 
    <!-- change sass to css in the end  -->
    <script src="<c:url value='/template/web/js/jquery-3.3.1.min.js'/> "></script>
    <link href="<c:url value='/template/sweetalert/sweetalert2.min.css' />" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<c:url value='/template/sweetalert/sweetalert2.min.js' />" ></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
    <script src="<c:url value='/template/paging/jquery.twbsPagination.min.js' />"></script>


</head>
<body>
<div class="wrap">
	
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->
	
	
	
	<div class="container">
		<dec:body />
	</div>
</div>
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->
	
	

	
    <script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/jquery.nice-select.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/jquery-ui.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/jquery.slicknav.js'/>"></script>
    <script src="<c:url value='/template/web/js/mixitup.min.js'/>"></script>
    <script src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>

    <script src="<c:url value='/template/web/js/main.js'/>"></script>
	
	

	
</body>
</html>