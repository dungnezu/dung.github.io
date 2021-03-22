package com.smartstore.service;

import java.util.List;

import com.smartstore.model.RoleModel;

public interface iRoleService {
	List<RoleModel> findAll();
	RoleModel findOne(Long id);
}
