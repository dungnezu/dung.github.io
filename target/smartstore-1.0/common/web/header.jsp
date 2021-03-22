<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- header -->
<!-- Page Preloader -->
<div id="preloader">
	<div class="loader"></div>
</div>
<!-- Page Preloader END -->

<!-- Hamburger (only visible on tablets and mobiles) -->
<div class="hamburger__menu__overlay"></div>
<div class="hamburger__menu__wrapper">
	<div class="hamburger__menu__logo">
		<a href="<c:url value='/trang-chu'/>"><img
			src="<c:url value='/template/web/img/logo.png'/> " alt=""></a>
	</div>
	<div class="hamburger__menu__cart">
		<ul>
			<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
			<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
		</ul>
		<div class="header__cart__price">
			<span>$10.00</span>
		</div>
	</div>
	<div class="hamburger__menu__widget">
		<div class="header__top__right__language">
			<img src="img/language.png" alt="">
			<div>English</div>
			<span class="arrow_carrot-down"></span>
			<ul>
				<li><a href="#">Spanish</a></li>
				<li><a href="#">English</a></li>
			</ul>
		</div>
		<div class="header__top__right__auth">
			<a href="#"><i class="fa fa-user"></i> Login</a>
		</div>
	</div>
	<nav class="hamburger__menu__nav mobile-menu">
		<ul>
			<li class="active"><a href="<c:url value='/trang-chu'/>">Home</a></li>
			<li><a href="./shop.html">Shop</a></li>
			<li><a href="./contact.html">Contact</a></li>
		</ul>
	</nav>
	<div id="mobile-menu-wrap"></div>
	<div class="header__top__right__social">
		<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
			class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
		<a href="#"><i class="fa fa-pinterest-p"></i></a>
	</div>
	<div class="hamburger__menu__contact">
		<ul>
			<li><i class="fa fa-envelope"></i> info@smartstore.com</li>
		</ul>
	</div>
</div>
<!-- Hamburger END -->

<!-- Header Section (on tablets and mobiles it's hidden) -->
<header class="header">
	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<!-- Left side of header -->
					<div class="header__top__left">
						<ul>
							<li><i class="fa fa-envelope"></i> info@smartstore.com</li>

						</ul>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<!-- Right side of header -->
					<div class="header__top__right">
						<div class="header__top__right__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-linkedin"></i></a> <a href="#"><i
								class="fa fa-pinterest-p"></i></a>
						</div>
						<c:if test="${not empty USERMODEL}">

							<div class="header__top__right__auth">
								<a href='<c:url value="/dang-nhap?action=login"/>'><i
									class="fa fa-user"></i>Xin chào, ${USERMODEL.user_ten}</a>
							</div>
							<div class="header__top__right__auth">
								<a href='<c:url value="/thoat?action=logout"/>'><i
									class="fa fa-user"></i>Thoát</a>
							</div>
						</c:if>
						<c:if test="${empty USERMODEL}">

							<div class="header__top__right__auth">
								<a href='<c:url value="/dang-nhap?action=login"/>'><i
									class="fa fa-user"></i>Đăng nhập</a>
							</div>
							<div class="header__top__right__auth">
								<a href='<c:url value="/dang-ky?action=dangky"/> '><i
									class="fa fa-user"></i>Đăng ký</a>
							</div>
						</c:if>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Navigation -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="<c:url value='/trang-chu'/>"><img src="<c:url value='/template/web/img/logo.png'/> " alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href= "<c:url value='/trang-chu'/>" >Trang chủ</a></li>
						<li><a href="<c:url value='/trang-chu'/>">Cửa Hàng</a></li>
						<li><a href="contact.html">Liên hệ</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
						<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
						<li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
					</ul>
					<div class="header__cart__price">
						<span>$10.00</span>
					</div>
				</div>
			</div>
		</div>
		<div class="hamburger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>
<!-- Header Section END -->
<!-- Hero Section -->
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>Sản phẩm</span>
						</div>
						<ul>
							<c:forEach var="item" items="${ brands}">
								<li><a
									href="<c:url value='/trang-chu?hangid=${item.hang_id}'/>">${item.hang_ten}</a></li>
							</c:forEach>
							<li><a href="#">Tai nghe</a></li>
							<li><a href="#">Phụ kiện</a></li>
							<li><a href="#">Smart watch</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<div class="hero__search__categories">
									All Categories <span class="arrow_carrot-down"></span>
								</div>
								<input type="text" placeholder="What are you looking for?">
								<button type="submit" class="site-btn">Tìm kiếm</button>
							</form>
						</div>
						<div class="hero__search__phone">
							<div class="hero__search__phone__icon">
								<i class="fa fa-phone"></i>
							</div>
							<div class="hero__search__phone__text">
								<h5>0944710830</h5>
								<span>24/7 Support</span>
							</div>
						</div>
					</div>
					<div class="hero__item set-bg"
						data-setbg="https://cdn.didongviet.vn/pub/media/magestore/bannerslider/images/6/7/670x393_228.png">

						<div class="hero__text">
							<a href="<c:url value='/trang-chu'/> " class="primary-btn">SHOP
								NOW</a>
						</div>

					</div>
				</div>
			</div>
	</section>
	<!-- Hero Section END -->


</div>