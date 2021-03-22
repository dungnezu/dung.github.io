package com.smartstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.smartstore.DAO.iLienHeDAO;
import com.smartstore.DAO.impl.LienHeDAO;
import com.smartstore.model.LienHeModel;
import com.smartstore.service.iLienHeService;

public class LienHeService implements iLienHeService{

	@Inject
	private iLienHeDAO lienheDAO;
	public LienHeService() {
		// TODO Auto-generated constructor stub
		lienheDAO= new LienHeDAO();
	}
	@Override
	public List<LienHeModel> findAll(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return lienheDAO.findAll2(offset, limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return lienheDAO.getTotalItem();
	}

}
