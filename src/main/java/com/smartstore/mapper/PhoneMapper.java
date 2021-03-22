package com.smartstore.mapper;

import java.sql.ResultSet;

import com.smartstore.model.BrandModel;
import com.smartstore.model.PhoneModel;

public class PhoneMapper implements RowMapper<PhoneModel> {

	@Override
	public PhoneModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			PhoneModel phone= new PhoneModel();
			phone.setDt_id(rs.getLong("dt_id"));
			phone.setDt_manhinh(rs.getString("dt_manhinh"));
			phone.setDt_ten(rs.getString("dt_ten"));
			phone.setDt_gia(rs.getString("dt_gia"));
			phone.setDt_camsau(rs.getString("dt_camsau"));
			phone.setDt_camtruoc(rs.getString("dt_camtruoc"));
			phone.setDt_mausac1(rs.getString("dt_mausac1"));
			
			phone.setDt_chip(rs.getString("dt_chip"));
			phone.setDt_ram(rs.getString("dt_ram"));
			phone.setDt_rom(rs.getString("dt_rom"));
			phone.setDt_sim(rs.getString("dt_sim"));
			phone.setDt_baomat(rs.getString("dt_baomat"));
			phone.setDt_pin(rs.getString("dt_pin"));
			phone.setDt_phukien(rs.getString("dt_phukien"));
			phone.setDt_anh1(rs.getString("dt_anh1"));
		
			phone.setDt_motangan(rs.getString("dt_motangan"));
			phone.setDt_hang_id(rs.getLong("dt_hang_id"));
			try {
				BrandModel brand = new BrandModel();
				brand.setHang_id(rs.getLong("hang_id"));
				brand.setHang_ten(rs.getString("hang_ten"));
				phone.setHang(brand);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.getMessage());
			}
			return phone;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
}
