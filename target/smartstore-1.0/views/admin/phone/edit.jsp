<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-phone"/>
<c:url var="uploadURL" value="/api-image"/>
<c:url var ="PhoneURL" value="/admin-phonelist"/>
<html>
<head>
    <title>Chỉnh sửa thông tin</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Thêm sản phẩm</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
						</c:if>
                        <form id="formSubmit">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Nhãn hiệu</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="dt_hang_id" name="dt_hang_id">
                                        <c:if test="${empty model.dt_hang_id}">
                                            <option value="">Chọn nhãn hiệu</option>
                                            <c:forEach var="item" items="${brands}">
                                                <option value="${item.hang_id}">${item.hang_ten}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.dt_hang_id}">
                                            <option value="">Chọn nhãn hiệu</option>
                                            <c:forEach var="item" items="${brands}">
                                                <option value="${item.hang_id}" <c:if test="${item.hang_id == model.dt_hang_id}">selected="selected"</c:if>>
                                                        ${item.hang_ten}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tên điện thoại</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_ten" name="dt_ten" value="${model.dt_ten}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Giá</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_gia" name="dt_gia" value="${model.dt_gia}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Màn hình</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_manhinh" name="dt_manhinh" value="${model.dt_manhinh}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Camera sau</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_camsau" name="dt_camsau" value="${model.dt_camsau}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Camera trước</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_camtruoc" name="dt_camtruoc" value="${model.dt_camtruoc}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Màu sắc</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="diachi" name="dt_mausac1" value="${model.dt_mausac1}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>        
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Chip xử lý</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_chip" name="dt_chip" value="${model.dt_chip}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Ram</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_ram" name="dt_ram" value="${model.dt_ram}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Bộ nhớ trong</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_rom" name="dt_rom" value="${model.dt_rom}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                             <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Hỗ trợ sim</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_sim" name="dt_sim" value="${model.dt_sim}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Bảo hành</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_baomat" name="dt_baomat" value="${model.dt_baomat}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                           
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Dung lương pin</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="diachi" name="dt_pin" value="${model.dt_pin}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Phụ kiện</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="dt_phukien" name="dt_phukien" value="${model.dt_phukien}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"> Ảnh minh họa</label>
                                <div class="col-sm-9">
                                    <input type="file" class="form-control" id="dt_anh1" name="dt_anh1" value="${model.dt_anh1}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="dt_motangan" name="dt_motangan" style="width: 820px;height: 175px">${model.dt_motangan}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.dt_id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật sản phẩm" id="btnAddOrUpdatephone"/>
                                    </c:if>
                                    <c:if test="${empty model.dt_id}">
                                    	
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm sản phẩm" id="btnAddOrUpdatephone"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" value="${model.dt_id}" id="id" name="id"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	 $(document).ready(function () {

	 })
	$('#dt_anh1').change(function () {
		var dataArray={};
		var files=$(this)[0].files[0];
		if(files != undefined){
			var reader = new FileReader();
			reader.onload=function (e) {
				dataArray["base64"]=e.target.result;
				dataArray["name"]=files.name;
				uploadFile(dataArray);
			};
			reader.readAsDataURL(files);
		}
	});
	 function uploadFile(data) {
		$.ajax({
			url: '${uploadURL}',
			type:'POST',
			data:JSON.stringify(data),
			contentType:'application/json',
			success:function (res) {
				console.log(res);
			},
			error:function (res) {
				console.log(res);

			}
		});
	 }
</script>
<script>
	
	var editor = '';
	$(document).ready(function(){
		editor = CKEDITOR.replace( 'dt_motangan');
	});
	
    $('#btnAddOrUpdatephone').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v ) {
            data[""+v.name+""] = v.value;
        });
        data["dt_motangan"] = editor.getData();
        var id = $('#id').val();
        if (id == "") {
            addNew(data);
        } else {
            updateNew(data);
        }
    });
    function addNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${PhoneURL}?type=list&id="+result.dt_id+"&page=1&maxPageItem=5&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${PhoneURL}?type=list&maxPageItem=5&page=1&message=error_system";
            }
        });
    }
    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${UserURL}?type=list&id="+result.dt_id+"&page=1&maxPageItem=5&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${UserURL}?type=list&maxPageItem=5&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>
