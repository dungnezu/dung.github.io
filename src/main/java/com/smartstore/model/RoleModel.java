package com.smartstore.model;

public class RoleModel  extends AbstractModel<RoleModel> {
	private Long role_id;
	private String role_ten;

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_ten() {
		return role_ten;
	}

	public void setRole_ten(String role_ten) {
		this.role_ten = role_ten;
	}

}
