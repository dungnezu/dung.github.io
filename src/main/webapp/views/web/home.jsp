<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/add-tocart" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>


	<!-- Featured Section -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Sản phẩm</h2>
					</div>
					<div class="featured__controls">
						<ul>
							<li class="active" data-filter="*"><a
								href="<c:url value='/trang-chu'/>">Tất cả</a></li>
							<c:forEach var="item" items="${ brands}">
								<li><a id="fid" style="color: #70369c;"
									href="<c:url value='/trang-chu?hangid=${item.hang_id}'/>">${item.hang_ten}</a></li>
							</c:forEach>

						</ul>

					</div>
				</div>
			</div>

			<div class="row featured__filter">
				<!-- 8 items/products -->
				<c:forEach var="item" begin="0" end="3" items="${model.listResult}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
						<div class="featured__item">
							<div class="featured__item__pic set-bg"
								data-setbg="/smartstore${item.dt_anh1}">
								<ul class="featured__item__pic__hover">

									<li><button type="button" class="addtocart"
											data-dtid="${item.dt_id}" data-userid="${USERMODEL.user_id}">
											<i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng
										</button></li>


								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<c:url var="detailURL" value="/chitiet_sp">
										<c:param name="id" value="${item.dt_id }" />
										<c:param name="userid" value="details" />
									</c:url>
									<a href='${detailURL}'>${item.dt_ten}</a>
								</h6>
								<h5>${item.dt_gia}đ</h5>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
			<form action="" id="formSubmit">
			<div class="row featured__filter">
				<!-- 8 items/products -->
				<c:forEach var="item" begin="4" end="7" items="${model.listResult}">
					<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
						<div class="featured__item">
							<div class="featured__item__pic set-bg"
								data-setbg="/smartstore${item.dt_anh1}">
								<ul class="featured__item__pic__hover">

									<li><button type="button" class="addtocart"
											data-dtid="${item.dt_id}" data-userid="${USERMODEL.user_id}">
											<i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng
										</button></li>


								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<c:url var="detailURL" value="/chitiet_sp">
										<c:param name="id" value="${item.dt_id }" />
										<c:param name="userid" value="details" />
									</c:url>
									<a href='${detailURL}'>${item.dt_ten}</a>
								</h6>
								<h5>${item.dt_gia}đ</h5>
							</div>
						</div>
					</div>
				</c:forEach>
				<ul class="pagination" id="pagination"></ul>
				<input type="hidden" value="" id="page" name="page" /> <input
					type="hidden" value="" id="maxPageItem" name="maxPageItem" /> <input
					type="hidden" value="" id="sortName" name="sortName" /> <input
					type="hidden" value="" id="sortBy" name="sortBy" /> <input
					type="hidden" value="" id="type" name="type" />

			</div>
			</form>

		</div>
	</section>
	<!-- Featured Section END -->


	<script>
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('title');
						$('#sortBy').val('desc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});
		$('.addtocart').on("click", function() {
			var gh_dt_id = $(this).data("dtid");
			var gh_user_id = $(this).data("userid");

			var data = {
				gh_dt_id : gh_dt_id,
				gh_user_id : gh_user_id
			};
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