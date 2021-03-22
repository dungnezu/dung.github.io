package com.smartstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.smartstore.DAO.iRoleDAO;
import com.smartstore.model.RoleModel;
import com.smartstore.service.iRoleService;

public class RoleService implements iRoleService {
	@Inject
	private iRoleDAO roleDAO;
	@Override
	public List<RoleModel> findAll() {
		
		return roleDAO.findAll();
	}
	@Override
	public RoleModel findOne(Long id) {
		// TODO Auto-generated method stub
		return roleDAO.findOne(id);
	}

}
