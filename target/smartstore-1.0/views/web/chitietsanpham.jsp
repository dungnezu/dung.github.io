<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem chi tiết sản phẩm</title>
</head>
<body>
	<!-- Breadcrumb Section -->
	<section class="breadcrumb-section set-bg"
		data-setbg="img/breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Thông tin sản phẩm</h2>
						<div class="breadcrumb__option">
							<a href="<c:url value='/trang-chu'/>">Home</a> <a href="<c:url value='/trang-chu'/>">Thông tin sản phẩm</a>
							<span>Thông tin sản phẩm</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section END -->
	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item--large" src="<c:url value='${model.dt_anh1}'/> " alt="">
						</div>

					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h3>${model.dt_ten}</h3>
						<div class="product__details__rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star-half-o"></i> <span>(18 reviews)</span>
						</div>
						<div class="product__details__price">${model.dt_gia}  đ</div>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty">
									<input type="text" value="1">
								</div>
							</div>
						</div>
						<a href="#" class="primary-btn">Thêm vào giỏ hàng</a> <a href="#"
							class="heart-icon"><span class="icon_heart_alt"></span></a>
						<ul>
							<li><b>Tình trạng</b> <span>Còn hàng</span></li>
							<li><b>Giao hàng</b> <span><samp>Giao hàng
										miến phí toàn quốc</samp></span></li>

							<li><b>Chia sẻ</b>
								<div class="share">
									<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
										class="fa fa-twitter"></i></a> <a href="#"><i
										class="fa fa-instagram"></i></a> <a href="#"><i
										class="fa fa-pinterest"></i></a>
								</div></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="product__details__tab">
						<!-- Bootstrap Dynamic Tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Mô
									tả</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-2" role="tab" aria-selected="false">Thông số kỹ
									thuật</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#tabs-3" role="tab" aria-selected="false">Đánh giá <span>(1)</span></a>
							</li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="tabs-1" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Mô Tả</h6>
									<p>${model.dt_motangan}</p>
								</div>
							</div>
							<div class="tab-pane" id="tabs-2" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Thông số kỹ thuật</h6>
									<table class="table table-striped">
										<thead>
											<tr>
												<th>Màn hình</th>
												<th>Camera sau</th>
												<th>Camera trước</th>
												<th>Màu sắc</th>
												<th>Chip xử lý</th>
												<th>Ram</th>
												<th>Bộ nhớ trong</th>
												<th>Hỗ trợ sim</th>
												<th>Bảo hành</th>
												<th>Dung lượng pin</th>
												<th>Phụ kiện</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>${model.dt_manhinh}</td>
												<td>${model.dt_camsau}</td>
												<td>${model.dt_camtruoc}</td>
												<td>${model.dt_mausac1}</td>
												<td>${model.dt_chip}</td>
												<td>${model.dt_ram}</td>
												<td>${model.dt_rom}</td>
												<td>${model.dt_sim}</td>
												<td>${model.dt_baomat}</td>
												<td>${model.dt_pin}</td>
												<td>${model.dt_phukien}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="tab-pane" id="tabs-3" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Products Infomation</h6>
									<p>Vestibulum ac diam sit amet quam vehicula elementum sed
										sit amet dui. Pellentesque in ipsum id orci porta dapibus.
										Proin eget tortor risus. Vivamus suscipit tortor eget felis
										porttitor volutpat. Vestibulum ac diam sit amet quam vehicula
										elementum sed sit amet dui. Donec rutrum congue leo eget
										malesuada.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Details Section END -->
</body>
</html>