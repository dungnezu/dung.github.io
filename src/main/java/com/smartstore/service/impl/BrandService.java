package com.smartstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.smartstore.DAO.iBrandDAO;
import com.smartstore.model.BrandModel;
import com.smartstore.service.iBrandService;

public class BrandService implements iBrandService {

	@Inject
	private iBrandDAO brandDAO;
	@Override
	public List<BrandModel> findAll() {
		// TODO Auto-generated method stub
		return brandDAO.findAll();
	}

	@Override
	public BrandModel findOne(Long id) {
		// TODO Auto-generated method stub
		return brandDAO.findOne(id);
	}

}
