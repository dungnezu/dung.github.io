package com.smartstore.mapper;

import java.sql.ResultSet;

import com.smartstore.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel>{

	@Override
	public RoleModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			RoleModel role = new RoleModel();
			role.setRole_id(rs.getLong("role_id"));
			role.setRole_ten(rs.getString("role_ten"));
			return role;
		} catch (Exception e) {
			return null;
		}
	}
	

}
