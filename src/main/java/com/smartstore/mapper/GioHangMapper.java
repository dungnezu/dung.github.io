package com.smartstore.mapper;

import java.sql.ResultSet;

import com.smartstore.model.BrandModel;
import com.smartstore.model.GiohangModel;
import com.smartstore.model.PhoneModel;
import com.smartstore.model.RoleModel;
import com.smartstore.model.UserModel;

public class GioHangMapper implements RowMapper<GiohangModel> {

	@Override
	public GiohangModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub

		try {
			GiohangModel giohang = new GiohangModel();
			giohang.setGh_id(rs.getLong("gh_id"));
			giohang.setGh_gia(rs.getLong("gh_gia"));
			giohang.setGh_soluongmua(rs.getLong("gh_soluongmua"));
			giohang.setGh_tongtien(rs.getLong("gh_tongtien"));
			giohang.setGh_dt_id(rs.getLong("gh_dt_id")); 
			giohang.setGh_user_id(rs.getLong("gh_user_id"));

			try {
				PhoneModel phone = new PhoneModel();
				phone.setDt_id(rs.getLong("dt_id"));
				phone.setDt_ten(rs.getString("dt_ten"));
				phone.setDt_manhinh(rs.getString("dt_manhinh"));
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
				try {
					BrandModel brand = new BrandModel();
					brand.setHang_id(rs.getLong("hang_id"));
					brand.setHang_ten(rs.getString("hang_ten"));
					phone.setHang(brand);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.print(e.getMessage());
				}
				
				giohang.setPhone(phone);
				
				
				UserModel user = new UserModel();
				user.setUser_id(rs.getLong("user_id"));
				user.setUser_ten(rs.getString("user_ten"));
				user.setUser_matkhau(rs.getString("user_matkhau"));
				user.setUser_sodienthoai(rs.getString("user_sodienthoai"));
				user.setUser_mail(rs.getString("user_mail"));
				try {
					RoleModel role = new RoleModel();
					role.setRole_id(rs.getLong("role_id"));
					role.setRole_ten(rs.getString("role_ten"));
					user.setRole(role);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.print(e.getMessage());
				}
				giohang.setUser(user);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return giohang;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
