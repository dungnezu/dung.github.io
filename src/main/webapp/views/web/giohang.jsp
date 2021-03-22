<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/add-tocart" />
<c:url var="giohangURL" value="/them_giohang" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng của bạn</title>
</head>
<body>
	<!-- Breadcrumb Section -->
	<section class="breadcrumb-section set-bg"
		data-setbg="/smartstore/template/web/img/breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Giỏ hàng</h2>
						<div class="breadcrumb__option">
							<a href="<c:url value='/trang-chu'/>">Home</a> <a
								href="<c:url value='/trang-chu'/>">Giỏ hàng</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section END -->
	<!-- Shoping Cart Section -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
            <form action="" id="formSubmit">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Tổng cộng</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${model.listResult}">
                                <tr>
                                    <td class="shoping__cart__item">
                                        <img src="/smartstore${item.phone.dt_anh1}" style="width:  50px; height: 75px;" alt="">
                                        <h5>${item.phone.dt_ten}</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        ${item.gh_gia}
                                    </td>
                                    <!-- *** -->
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input type="text" value="${item.gh_soluongmua}">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                        ${item.gh_soluongmua*item.gh_gia} đ
                                    </td>
                                    <td class="shoping__cart__item__close">
                                    <input type="hidden" id="gh${item.gh_id}"  value="${ item.gh_id}" class="ghid" />
                                    <input type="hidden" id="dt${item.gh_id}" value="${ item.gh_dt_id}" class="dtid" />
                                    <button  type="button"  class="delete" title='Xóa khỏi giỏ hàng' data-id="${item.gh_id}">Xóa</button>
                                   
                                        
                                    </td>
                                </tr>
                                </c:forEach>
                               
                            </tbody>
                        </table>
                        <ul class="pagination" id="pagination"></ul>
				<input type="hidden" value="" id="page" name="page" /> <input
					type="hidden" value="" id="maxPageItem" name="maxPageItem" /> <input
					type="hidden" value="" id="sortName" name="sortName" /> <input
					type="hidden" value="" id="sortBy" name="sortBy" /> <input
					type="hidden" value="" id="type" name="type" />
                        
                    </div>
                </div>
                </form>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="<c:url value='/trang-chu'/>"  class="primary-btn cart-btn">Tiếp tục mua sắm</a>
                        <a href="#" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                            Chỉnh sửa</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Tổng tiền</h5>
                        <ul>
                            	
                            <li><span>${item.gh_soluongmua*item.gh_gia}</span></li>
                        </ul>
                        <a href="#" class="primary-btn">Đặt hàng</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->
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
		$('.delete').on("click", function(){
			var id=$(this).data("id");
			
			swal({
				  title: "Xác nhận xóa",
				  text: "Bạn có chắc chắn muốn xóa hay không",
				  type: "warning",
				  showCancelButton: true,
				  confirmButtonClass: "btn-success",
				  cancelButtonClass: "btn-danger",
				  confirmButtonText: "Xác nhận",
				  cancelButtonText: "Hủy bỏ",
				}).then(function(isConfirm) {
				  if (isConfirm) {
					  var data = {};
					  var  gh_id=$("#gh"+id).val();
						var gh_dt_id=$("#dt"+id).val();
						data={gh_dt_id:gh_dt_id,gh_id:gh_id};
						deletecart(data);
				  }
				});
			
		})
		
		function deletecart(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {

					alert("Bạn đã xóa 1 mặt hàng");
					window.location.href = "${giohangURL}?page=1&maxPageItem=5";
				},
				error : function(error) {
					alert("Xóa mặt hàng này không thành công");
					window.location.href = "${giohangURL}?page=1&maxPageItem=5";
				}
			});
		}
	</script>
</body>
</html>