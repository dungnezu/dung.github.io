<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/add-tocart" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xem chi tiết sản phẩm</title>
</head>
<body>
	<!-- Breadcrumb Section -->
	<section class="breadcrumb-section set-bg"
		data-setbg="/smartstore/template/web/img/breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Thông tin sản phẩm</h2>
						<div class="breadcrumb__option">
							<a href="<c:url value='/trang-chu'/>">Home</a> <a
								href="<c:url value='/trang-chu'/>">Thông tin sản phẩm</a> <span>Thông
								tin sản phẩm</span>
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
							<img class="product__details__pic__item--large"
								src="<c:url value='${model.dt_anh1}'/> " alt="">
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
						<div class="product__details__price">${model.dt_gia}đ</div>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty">
									<input type="text" id="gh_soluongmua" value="1">
								</div>
							</div>
						</div>
						<button type="button" class="primary-btn" id="addtocart" data-dtid="${model.dt_id}" data-userid="${USERMODEL.user_id}" data-gia=${model.dt_gia }>Thêm vào giỏ hàng</button>
						
						 <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
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
								<div class="product__details__tab__desc" >
									<h6>Thông số kỹ thuật</h6>
									<ul>
										<li>Màn hình : ${model.dt_manhinh}</li>
									</ul>
									<ul>
										<li>Camera sau : ${model.dt_camsau}</li>
									</ul>
									<ul>
										<li>Camera trước : ${model.dt_camtruoc}</li>
									</ul>
									<ul>
										<li>Màu sắc : ${model.dt_mausac1}</li>
									</ul>
									<ul>
										<li>Chip xử lý : ${model.dt_chip}</li>
									</ul>
									<ul>
										<li>Dung lượng Ram : ${model.dt_ram}</li>
									</ul>
									<ul>
										<li>Bộ nhớ trong : ${model.dt_rom}</li>
									</ul>
									<ul>
										<li>Hỗ trợ sim : ${model.dt_sim}</li>
									</ul>
									<ul>
										<li>Bảo hành : ${model.dt_baomat}</li>
									</ul>
									<ul>
										<li>Dung lượng pin : ${model.dt_pin}</li>
									</ul>
									<ul>
										<li>Phụ kiện : ${model.dt_phukien}</li>

									</ul>


								</div>
							</div>
							<div class="tab-pane" id="tabs-3" role="tabpanel">
								<div class="product__details__tab__desc">
									<h6>Đánh giá</h6>
									<p>Chưa có đánh giá</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Details Section END -->
	<script>
		$('#addtocart').on("click", function(){
			var gh_dt_id=$(this).data("dtid");
			var gh_user_id=$(this).data("userid");
			var gh_gia=$(this).data("gia");
			var gh_soluongmua=$("#gh_soluongmua").val();
			
			var data={gh_dt_id:gh_dt_id,gh_user_id:gh_user_id,gh_gia:gh_gia,gh_soluongmua:gh_soluongmua};
			addtocart(data);
		})
		function addtocart(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {

					alert(" Thêm vào giỏ hàng thành công");
				},
				error : function(error) {
					alert("Bạn chưa đăng nhập");
				}
			});
		}
	</script>
</body>
</html>