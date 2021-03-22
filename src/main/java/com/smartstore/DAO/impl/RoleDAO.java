package com.smartstore.DAO.impl;

import java.util.List;

import com.smartstore.DAO.iRoleDAO;
import com.smartstore.mapper.RoleMapper;
import com.smartstore.mapper.UserMapper;
import com.smartstore.model.RoleModel;
import com.smartstore.model.UserModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements iRoleDAO{

	

	@Override
	public List<RoleModel> findAll() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tblrole";
		return query(sql, new RoleMapper());
	}

	@Override
	public Long save(RoleModel rm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RoleModel update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoleModel> findAll2(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RoleModel findOne(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM smartstore.tblrole WHERE role_id=?";
		List<RoleModel> roles = query(sql.toString(), new RoleMapper(), id);

		return roles.isEmpty() ? null : roles.get(0);
	}

}
