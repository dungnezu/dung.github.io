package com.smartstore.model;

public class GiohangModel extends AbstractModel<GiohangModel> {
	private Long   gh_id ;
	private Long   gh_dt_id ;
	private Long   gh_user_id;
	private Long    gh_gia;
	private Long   gh_soluongmua;
	private Long   gh_tongtien ;
	
	private PhoneModel phone= new PhoneModel();
	private UserModel user=new UserModel()    ;
	
	public Long getGh_id() {
		return gh_id;
	}
	public void setGh_id(Long gh_id) {
		this.gh_id = gh_id;
	}
	public Long getGh_dt_id() {
		return gh_dt_id;
	}
	public void setGh_dt_id(Long gh_dt_id) {
		this.gh_dt_id = gh_dt_id;
	}
	public Long getGh_user_id() {
		return gh_user_id;
	}
	public void setGh_user_id(Long gh_user_id) {
		this.gh_user_id = gh_user_id;
	}
	public Long getGh_soluongmua() {
		return gh_soluongmua;
	}
	public void setGh_soluongmua(Long gh_soluongmua) {
		this.gh_soluongmua = gh_soluongmua;
	}
	public Long getGh_tongtien() {
		return gh_tongtien;
	}
	public void setGh_tongtien(Long gh_tongtien) {
		this.gh_tongtien = gh_tongtien;
	}
	public PhoneModel getPhone() {
		return phone;
	}
	public void setPhone(PhoneModel phone) {
		this.phone = phone;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public Long getGh_gia() {
		return gh_gia;
	}
	public void setGh_gia(Long gh_gia) {
		this.gh_gia = gh_gia;
	}
	
}
