package com.smartstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.smartstore.DAO.iRoleDAO;
import com.smartstore.DAO.iUserDAO;
import com.smartstore.DAO.impl.UserDAO;
import com.smartstore.model.RoleModel;
import com.smartstore.model.UserModel;
import com.smartstore.service.iUserService;

public class UserService implements iUserService {
	
	@Inject
	private iUserDAO userDAO;
	@Inject
	private iRoleDAO roleDAO;
	public  UserService() {
		userDAO=new UserDAO();
	}
	@Override
	public UserModel findByUserPass(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.findbyUserpass(username, password);
	}
	@Override
	public List<UserModel> findAll(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return userDAO.findAll2(offset, limit);
	}
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return userDAO.getTotalItem();
	}
	@Override
	public Long insert(UserModel um) {
		// TODO Auto-generated method stub
		return userDAO.save2(um);
	}
	@Override
	public UserModel findOne(Long id) {
		// TODO Auto-generated method stub
		UserModel userModel= userDAO.findOne(id);
		RoleModel rolemodel= roleDAO.findOne(userModel.getUser_role_id());
		userModel.setUser_role_id(rolemodel.getRole_id());
		return userModel;
	}
	@Override
	public UserModel insert2(UserModel um) {
		// TODO Auto-generated method stub
		RoleModel role=roleDAO.findOne(um.getUser_role_id());
		um.setUser_role_id(role.getRole_id());
		Long userId=userDAO.save(um);
		return userDAO.findOne(userId);
	}
	@Override
	public UserModel update(UserModel um) {
		
		userDAO.update(um);
		return userDAO.findOne(um.getId());
		
	}
	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			userDAO.delete(id);
		}
	}

}
