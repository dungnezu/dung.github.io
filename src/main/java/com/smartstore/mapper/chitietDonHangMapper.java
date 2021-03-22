package com.smartstore.mapper;

import java.sql.ResultSet;

import com.smartstore.model.BrandModel;
import com.smartstore.model.DonHangModel;
import com.smartstore.model.PhoneModel;
import com.smartstore.model.RoleModel;
import com.smartstore.model.UserModel;
import com.smartstore.model.chitietDonHangModel;

public class chitietDonHangMapper implements RowMapper<chitietDonHangModel> {

	@Override
	public chitietDonHangModel mapRow(ResultSet rs) {
		try {
			chitietDonHangModel ctdh = new chitietDonHangModel();
			ctdh.setCt_soluong(rs.getLong("ct_soluong"));
			ctdh.setCt_gia(rs.getLong("ct_gia"));
			ctdh.setCt_thanhtien(rs.getLong("ct_thanhtien"));

			DonHangModel donhang = new DonHangModel();
			donhang.setDh_id(rs.getLong("dh_id"));
			donhang.setDh_ngaylap(rs.getString("dh_ngaylap"));
			donhang.setDh_user_id(rs.getLong("dh_user_id"));
			donhang.setDh_tongtien(rs.getLong("dh_tongtien"));

			UserModel user = new UserModel();
			user.setUser_id(rs.getLong("user_id"));
			user.setUser_ten(rs.getString("user_ten"));
			user.setUser_matkhau(rs.getString("user_matkhau"));
			user.setUser_sodienthoai(rs.getString("user_sodienthoai"));
			user.setUser_mail(rs.getString("user_mail"));
			user.setUser_diachi(rs.getString("user_diachi"));
			
			RoleModel role = new RoleModel();
			role.setRole_id(rs.getLong("role_id"));
			role.setRole_ten(rs.getString("role_ten"));
			user.setRole(role);

			donhang.setUser(user);

			PhoneModel phone = new PhoneModel();
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

			BrandModel brand = new BrandModel();
			brand.setHang_id(rs.getLong("hang_id"));
			brand.setHang_ten(rs.getString("hang_ten"));
			phone.setHang(brand);

			ctdh.setDonhang(donhang);
			ctdh.setPhone(phone);
			return ctdh;
		} catch (

		Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
