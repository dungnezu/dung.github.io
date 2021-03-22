package com.smartstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.smartstore.DAO.iGioHangDAO;
import com.smartstore.DAO.iPhoneDAO;
import com.smartstore.model.GiohangModel;
import com.smartstore.model.PhoneModel;
import com.smartstore.service.iGioHangService;

public class GioHangService implements iGioHangService {
	@Inject
	private iGioHangDAO giohangDAO;
	@Inject
	private iPhoneDAO phoneDAO;
	@Override
	public List<GiohangModel> findAll(Integer offset, Integer limit ,Long id) {
		// TODO Auto-generated method stub
		
		return giohangDAO.findAll2(offset, limit ,id);
	}
	@Override
	public List<GiohangModel> findAll2(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		
		return giohangDAO.findAll(offset, limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return giohangDAO.getTotalItem();
	}

	@Override
	public GiohangModel insert(GiohangModel ghm) {
		// TODO Auto-generated method stub
		if(ghm.getGh_gia()==null&&ghm.getGh_soluongmua()==null) {
			PhoneModel pm=phoneDAO.findOne(ghm.getGh_dt_id());
			ghm.setGh_gia(Long.parseLong(pm.getDt_gia()) );
			
			ghm.setGh_soluongmua((long) (1));
		}
		ghm.setGh_tongtien(ghm.getGh_gia()*ghm.getGh_soluongmua());
		Long id=giohangDAO.save(ghm);
		return giohangDAO.findOne(id);
	}

	@Override
	public GiohangModel update(GiohangModel ghm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long ghid, Long dtid) {
		
		giohangDAO.delete(ghid,dtid);
	}
	@Override
	public GiohangModel findOne(Long id) {
		// TODO Auto-generated method stub
		return giohangDAO.findOne(id);
	}



}
