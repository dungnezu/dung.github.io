package com.smartstore.model;

public class UserModel extends AbstractModel<UserModel> {
	private Long user_id;
	private String user_ten;
	private String user_matkhau;
	private String user_sodienthoai;
	private String user_mail;
	private String user_diachi;
	private Long user_role_id;
	private RoleModel role = new RoleModel();

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_ten() {
		return user_ten;
	}

	public void setUser_ten(String user_ten) {
		this.user_ten = user_ten;
	}

	public String getUser_matkhau() {
		return user_matkhau;
	}

	public void setUser_matkhau(String user_matkhau) {
		this.user_matkhau = user_matkhau;
	}

	public String getUser_sodienthoai() {
		return user_sodienthoai;
	}

	public void setUser_sodienthoai(String user_sodienthoai) {
		this.user_sodienthoai = user_sodienthoai;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public Long getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(Long user_role_id) {
		this.user_role_id = user_role_id;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public String getUser_diachi() {
		return user_diachi;
	}

	public void setUser_diachi(String user_diachi) {
		this.user_diachi = user_diachi;
	}

}
