package com.smartstore.model;

public class YeuThichModel extends AbstractModel<YeuThichModel> {
	private Long yt_id;
	
	private Long yt_dt_id;
	
	private Long soLuongBan;
	private Long yt_user_id;
	
	private PhoneModel phone = new PhoneModel();
	private UserModel user = new UserModel();

	public Long getYt_id() {
		return yt_id;
	}

	public void setYt_id(Long yt_id) {
		this.yt_id = yt_id;
	}

	public Long getYt_dt_id() {
		return yt_dt_id;
	}

	public void setYt_dt_id(Long yt_dt_id) {
		this.yt_dt_id = yt_dt_id;
	}

	public Long getSoLuongBan() {
		return soLuongBan;
	}

	public void setSoLuongBan(Long soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

	public Long getYt_user_id() {
		return yt_user_id;
	}

	public void setYt_user_id(Long yt_user_id) {
		this.yt_user_id = yt_user_id;
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
}
