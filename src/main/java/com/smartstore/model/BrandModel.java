package com.smartstore.model;

public class BrandModel extends AbstractModel<BrandModel> {
	private Long hang_id;
	private String hang_ten;

	public Long getHang_id() {
		return hang_id;
	}

	public void setHang_id(Long hang_id) {
		this.hang_id = hang_id;
	}

	public String getHang_ten() {
		return hang_ten;
	}

	public void setHang_ten(String hang_ten) {
		this.hang_ten = hang_ten;
	}
}
