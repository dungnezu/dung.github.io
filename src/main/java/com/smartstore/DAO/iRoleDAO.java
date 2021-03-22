package com.smartstore.DAO;

import java.util.List;

import com.smartstore.model.RoleModel;
import com.smartstore.model.UserModel;
import com.smartstore.model.YeuThichModel;

public interface iRoleDAO extends GenericDAO<RoleModel> {
	List<RoleModel> findAll();

	Long save(RoleModel rm);

	void update(RoleModel update);

	void delete(Long id);

	List<RoleModel> findAll2(Integer offset, Integer limit);

	int getTotalItem();
	RoleModel findOne(Long id);
}
