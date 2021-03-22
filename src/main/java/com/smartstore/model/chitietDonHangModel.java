package com.smartstore.model;

public class chitietDonHangModel {
	private Long dh_id;
	private Long dt_id;
	private Long ct_soluong;
	private Long ct_gia;
	private Long ct_thanhtien;
	private DonHangModel donhang=new DonHangModel();
	private PhoneModel phone=new PhoneModel();
	public Long getDh_id() {
		return dh_id;
	}
	public void setDh_id(Long dh_id) {
		this.dh_id = dh_id;
	}
	public Long getDt_id() {
		return dt_id;
	}
	public void setDt_id(Long dt_id) {
		this.dt_id = dt_id;
	}
	public Long getCt_soluong() {
		return ct_soluong;
	}
	public void setCt_soluong(Long ct_soluong) {
		this.ct_soluong = ct_soluong;
	}
	public Long getCt_gia() {
		return ct_gia;
	}
	public void setCt_gia(Long ct_gia) {
		this.ct_gia = ct_gia;
	}
	public Long getCt_thanhtien() {
		return ct_thanhtien;
	}
	public void setCt_thanhtien(Long ct_thanhtien) {
		this.ct_thanhtien = ct_thanhtien;
	}
	public DonHangModel getDonhang() {
		return donhang;
	}
	public void setDonhang(DonHangModel donhang) {
		this.donhang = donhang;
	}
	public PhoneModel getPhone() {
		return phone;
	}
	public void setPhone(PhoneModel phone) {
		this.phone = phone;
	}
	
}
