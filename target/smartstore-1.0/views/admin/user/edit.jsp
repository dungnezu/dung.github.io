<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-user"/>
<c:url var ="UserURL" value="/admin-userlist"/>
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
                <li class="active">Thêm người dùng</li>
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
                                <label class="col-sm-3 control-label no-padding-right">Chức năng</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="user_role_id" name="user_role_id">
                                        <c:if test="${empty model.user_role_id}">
                                            <option value="">Chọn chức năng</option>
                                            <c:forEach var="item" items="${roles}">
                                                <option value="${item.role_id}">${item.role_ten}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.user_role_id}">
                                            <option value="">Chọn chức năng</option>
                                            <c:forEach var="item" items="${roles}">
                                                <option value="${item.role_id}" <c:if test="${item.role_id == model.user_role_id}">selected="selected"</c:if>>
                                                        ${item.role_ten}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tên đăng nhập</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="title" name=" " value="${model.user_ten}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Mật khẩu</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="password" name="user_matkhau" value="${model.user_matkhau}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Số điện thoại</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="sodt" name="user_sodienthoai" value="${model.user_sodienthoai}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Địa chỉ email</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="email" name="user_mail" value="${model.user_mail}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Địa chỉ</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="diachi" name="user_diachi" value="${model.user_diachi}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.user_id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật người dùng" id="btnAddOrUpdateuser"/>
                                    </c:if>
                                    <c:if test="${empty model.user_id}">
                                    	
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm người dùng" id="btnAddOrUpdateuser"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" value="${model.user_id}" id="id" name="id"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	var editor = '';
	$(document).ready(function(){
		editor = CKEDITOR.replace( 'content');
	});
	
    $('#btnAddOrUpdateuser').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v ) {
            data[""+v.name+""] = v.value;
        });
       
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
            	window.location.href = "${UserURL}?type=list&id="+result.id+"&page=1&maxPageItem=5&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${UserURL}?type=list&maxPageItem=5&page=1&message=error_system";
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
            	window.location.href = "${UserURL}?type=list&id="+result.user_id+"&page=1&maxPageItem=5&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${UserURL}?type=list&maxPageItem=5&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>
