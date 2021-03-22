package com.smartstore.DAO.impl;

import java.util.List;

import com.smartstore.DAO.iChitietDonHangDAO;
import com.smartstore.model.chitietDonHangModel;

public class ChiTietDonHangDAO extends AbstractDAO<chitietDonHangModel> implements iChitietDonHangDAO{
	@Override
	public List<chitietDonHangModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(chitietDonHangModel ctdh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(chitietDonHangModel ctdh) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long dh_id, Long dt_id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tblchitietdonhang WHERE dh_id=? and dt_id=?";
		delete(sql, dh_id,dt_id);
	}

	@Override
	public List<chitietDonHangModel> findAll2(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
