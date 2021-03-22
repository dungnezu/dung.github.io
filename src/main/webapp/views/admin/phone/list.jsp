<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-phone" />
<c:url var="PhoneURL" value="/admin-phonelist" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách điện thoại</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value='/admin-phonelist'/>" id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty messageResponse}">
								<div class="alert alert-${alert}">${messageResponse}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm sản phẩm'
												href='<c:url value="/admin-phonelist?type=edit"/>'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="" type="button" onclick="warningBeforeDelete()"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa sản phẩm'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll"></th>

													<th>Tên điện thoại</th>
													<th>Giá</th>
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
													<th>Ảnh</th>
													<th>Mô tả ngắn</th>
													<th>Nhãn hiệu</th>													
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${model.listResult}">
													<tr>
														<td><input type="checkbox"
															id="checkbox_${item.dt_id}" value="${item.dt_id}"></td>
														<td>${item.dt_ten}</td>
														<td>${item.dt_gia}</td>
														<td>${item.dt_manhinh}</td>
														<td>${item.dt_camsau}</td>
														<td>${item.dt_camtruoc}</td>
														<td>${item.dt_mausac1}</td>
														<td>${item.dt_chip}</td>
														<td>${item.dt_ram}</td>
														<td>${item.dt_rom}</td>
														<td>${item.dt_sim}</td>
														<td>${item.dt_baomat}</td>
														<td>${item.dt_pin}</td>
														<td>${item.dt_phukien}</td>
														<td><img src="/smartstore${item.dt_anh1}" alt="" style="width: 80px; height: 100px" /></td>
														<td>${item.dt_motangan}</td>
														<td>${item.hang.hang_ten}</td>
														<td><c:url var="editURL" value="/admin-phonelist">
																<c:param name="type" value="edit" />
																<c:param name="id" value="${item.dt_id}" />
															</c:url> <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật sản phẩm"
															href='${editURL}'><i class="fa fa-pencil-square-o"
																aria-hidden="true"></i> </a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
											<input type="hidden" value="" id="sortName" name="sortName"/>
											<input type="hidden" value="" id="sortBy" name="sortBy"/>
											<input type="hidden" value="" id="type" name="type"/>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
	var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
	var limit = 5;
	$(function () {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages: totalPages,
			visiblePages: 10,
			startPage: currentPage,
			onPageClick: function (event, page) {
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
	
/* 	$("#btnDelete").click(function() {
		var data = {};
		var ids = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
		data['ids'] = ids;
		deleteNew(data);
	}) */
	function warningBeforeDelete() {
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
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
		            return $(this).val();
		        }).get();
				data['ids'] = ids;
				deleteNew(data);
		  } else
			  {
			  
			  }
		});
}
	
	function deleteNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${PhoneURL}?type=list&maxPageItem=5&page=1&message=delete_success";
            },
            error: function (error) {
            	window.location.href = "${PhoneURL}?type=list&maxPageItem=5&page=1&message=error_system";
            }
        });
    }
	</script>
</body>

</html>