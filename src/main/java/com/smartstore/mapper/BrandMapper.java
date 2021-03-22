package com.smartstore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.smartstore.model.BrandModel;

public class BrandMapper implements RowMapper<BrandModel> {

	@Override
	public BrandModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			BrandModel brand = new BrandModel();
			brand.setHang_id(rs.getLong("hang_id"));
			brand.setHang_ten(rs.getString("hang_ten"));
			return brand;

		} catch (SQLException e) {
			return null;
		}
	}

}
