package com.smartstore.mapper;

import java.sql.ResultSet;

import com.smartstore.model.RoleModel;
import com.smartstore.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			UserModel user = new UserModel();
			user.setUser_id(rs.getLong("user_id"));
			user.setUser_ten(rs.getString("user_ten"));
			user.setUser_matkhau(rs.getString("user_matkhau"));
			user.setUser_sodienthoai(rs.getString("user_sodienthoai"));
			user.setUser_mail(rs.getString("user_mail"));
			user.setUser_diachi(rs.getString("user_diachi"));
			user.setUser_role_id(rs.getLong("user_role_id"));
			try {
				RoleModel role = new RoleModel();
				role.setRole_id(rs.getLong("role_id"));
				role.setRole_ten(rs.getString("role_ten"));
				user.setRole(role);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.getMessage());
			}
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

		
	}

}
