package com.smartstore.model;

public class LienHeModel  extends AbstractModel<LienHeModel> {
	private Long lh_id;
	private String lh_hoten;
	private String lh_email;
	private String lh_sodt;
	private String lh_noidung;

	public Long getLh_id() {
		return lh_id;
	}

	public void setLh_id(Long lh_id) {
		this.lh_id = lh_id;
	}

	public String getLh_hoten() {
		return lh_hoten;
	}

	public void setLh_hoten(String lh_hoten) {
		this.lh_hoten = lh_hoten;
	}

	public String getLh_email() {
		return lh_email;
	}

	public void setLh_email(String lh_email) {
		this.lh_email = lh_email;
	}

	public String getLh_sodt() {
		return lh_sodt;
	}

	public void setLh_sodt(String lh_sodt) {
		this.lh_sodt = lh_sodt;
	}

	public String getLh_noidung() {
		return lh_noidung;
	}

	public void setLh_noidung(String lh_noidung) {
		this.lh_noidung = lh_noidung;
	}

}
