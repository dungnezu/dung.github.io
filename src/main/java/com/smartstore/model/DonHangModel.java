package com.smartstore.model;

import java.sql.Timestamp;

public class DonHangModel extends AbstractModel<DonHangModel> {
	private Long dh_id;
	private Long gh_id;
	private Long dh_user_id;
	private String dh_ngaylap;
	private Long dh_tongtien;
	private boolean dh_tinhtrang;
	
	private GiohangModel giohang=new GiohangModel();
	private UserModel user=new UserModel();
	public Long getDh_id() {
		return dh_id;
	}
	public void setDh_id(Long dh_id) {
		this.dh_id = dh_id;
	}
	public String getDh_ngaylap() {
		return dh_ngaylap;
	}
	public void setDh_ngaylap(String dh_ngaylap) {
		this.dh_ngaylap = dh_ngaylap;
	}
	public Long getDh_user_id() {
		return dh_user_id;
	}
	public void setDh_user_id(Long dh_user_id) {
		this.dh_user_id = dh_user_id;
	}
	public Long getDh_tongtien() {
		return dh_tongtien;
	}
	public void setDh_tongtien(Long dh_tongtien) {
		this.dh_tongtien = dh_tongtien;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public boolean isDh_tinhtrang() {
		return dh_tinhtrang;
	}
	public void setDh_tinhtrang(boolean dh_tinhtrang) {
		this.dh_tinhtrang = dh_tinhtrang;
	}
	public Long getGh_id() {
		return gh_id;
	}
	public void setGh_id(Long gh_id) {
		this.gh_id = gh_id;
	}
	public GiohangModel getGiohang() {
		return giohang;
	}
	public void setGiohang(GiohangModel giohang) {
		this.giohang = giohang;
	}
}
