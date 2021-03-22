package com.smartstore.mapper;

import java.sql.ResultSet;

import com.smartstore.model.LienHeModel;

public class LienHeMapper implements RowMapper<LienHeModel> {

	@Override
	public LienHeModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			LienHeModel lienhe=new LienHeModel();
			lienhe.setLh_id(rs.getLong("lh_id"));
			lienhe.setLh_hoten(rs.getString("lh_hoten"));
			lienhe.setLh_email(rs.getString("lh_email"));
			lienhe.setLh_sodt(rs.getString("lh_sodt"));
			lienhe.setLh_noidung(rs.getString("lh_noidung"));
			return lienhe;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
