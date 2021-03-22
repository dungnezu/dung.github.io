package com.smartstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.smartstore.DAO.iDonHangDAO;
import com.smartstore.DAO.iGioHangDAO;
import com.smartstore.DAO.iPhoneDAO;
import com.smartstore.model.DonHangModel;
import com.smartstore.model.GiohangModel;
import com.smartstore.model.PhoneModel;
import com.smartstore.service.iDonHangService;

public class DonHangService implements iDonHangService{

	@Inject
	private iDonHangDAO donhangDAO;
	@Inject
	private iGioHangDAO giohangDAO;
	@Override
	public List<DonHangModel> findAll(Integer offset, Integer limit, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return donhangDAO.getTotalItem();
	}

	@Override
	public DonHangModel insert(DonHangModel ghm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DonHangModel update(DonHangModel ghm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long ghid, Long dtid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DonHangModel> findAll2(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		List<DonHangModel> list = donhangDAO.findAll2(offset, limit);
		for (DonHangModel item : list) {
			GiohangModel gm= giohangDAO.findOne(item.getGh_id());
			item.setGiohang(gm);;
		}
		return list;
	}

	@Override
	public DonHangModel findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
