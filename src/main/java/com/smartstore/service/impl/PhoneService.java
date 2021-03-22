package com.smartstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.smartstore.DAO.iBrandDAO;
import com.smartstore.DAO.iPhoneDAO;
import com.smartstore.model.BrandModel;
import com.smartstore.model.PhoneModel;
import com.smartstore.model.RoleModel;
import com.smartstore.model.UserModel;
import com.smartstore.service.iPhoneService;

public class PhoneService implements iPhoneService {

	@Inject
	private iPhoneDAO phoneDAO;
	@Inject
	private iBrandDAO brandDAO;
	@Override
	public PhoneModel save(PhoneModel newModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneModel> findAll(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return phoneDAO.findAll2(offset, limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return phoneDAO.getTotalItem();
	}

	@Override
	public PhoneModel insert(PhoneModel pm) {
		// TODO Auto-generated method stub
		
		
		BrandModel  brandModel= brandDAO.findOne(pm.getDt_hang_id());
		pm.setDt_hang_id(brandModel.getHang_id());
		Long phoneid=phoneDAO.save(pm);
		return phoneDAO.findOne(phoneid);
		
	}
	

	@Override
	public PhoneModel update(PhoneModel pm) {
		// TODO Auto-generated method stub
		
		phoneDAO.update(pm);
		return phoneDAO.findOne(pm.getId());
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			phoneDAO.delete(id);
		}
	}

	@Override
	public PhoneModel findOne(Long id) {
		// TODO Auto-generated method stub
		PhoneModel phoneModel=phoneDAO.findOne(id);
		BrandModel brandModel=brandDAO.findOne(phoneModel.getDt_hang_id());
		phoneModel.setDt_hang_id(brandModel.getHang_id());
		return phoneModel;
	}

	@Override
	public List<PhoneModel> findAllbyhangID(Integer offset, Integer limit, Long hangid) {
		// TODO Auto-generated method stub
		return phoneDAO.findAllbyhangId(offset, limit,hangid);
	}

}
