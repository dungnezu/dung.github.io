package com.smartstore.DAO.impl;

import java.util.List;

import com.smartstore.DAO.iUserDAO;
import com.smartstore.mapper.UserMapper;
import com.smartstore.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements iUserDAO {

	@Override
	public UserModel findbyUserpass(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbluser AS " + "u INNER JOIN tblrole AS r ON r.role_id = u.user_role_id "
				+ "WHERE u.user_ten = ? AND u.user_matkhau = ?";
		List<UserModel> users = query(sql.toString(), new UserMapper(), username, password);

		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long save(UserModel um) {
		// TODO Auto-generated method stub
		String sql = "insert into tbluser(user_ten,user_matkhau,user_sodienthoai,"
				+ "user_mail,user_diachi,user_role_id) VALUES (?,?,?,?,?,?)";

		return insert(sql, um.getUser_ten(), um.getUser_matkhau(), um.getUser_sodienthoai(), um.getUser_mail(),
				um.getUser_diachi(), um.getUser_role_id());
	}

	@Override
	public Long save2(UserModel um) {
		// TODO Auto-generated method stub
		String sql = "insert into tbluser(user_ten,user_matkhau,user_sodienthoai,user_mail,user_diachi,user_role_id) VALUES (?,?,?,?,?,?)";

		return insert(sql, um.getUser_ten(), um.getUser_matkhau(), um.getUser_sodienthoai(), um.getUser_mail(),
				um.getUser_diachi(), 2);
	}

	@Override
	public void update(UserModel um) {
		// TODO Auto-generated method stub
		String sql = "update tbluser" + " set user_ten=? ,user_matkhau=? "
				+ ",user_sodienthoai=?,user_mail=? ,user_diachi=?, user_role_id=? " + "where user_id=?";

		update(sql, um.getUser_ten(), um.getUser_matkhau(), um.getUser_sodienthoai(), um.getUser_mail(),
				um.getUser_diachi(),um.getUser_role_id(), um.getId());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbluser WHERE user_id=?";
		delete(sql, id);
	}

	@Override
	public List<UserModel> findAll2(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbluser AS u INNER JOIN tblrole AS r ON r.role_id = u.user_role_id  "
				+ "LIMIT ?,?";
		return query(sql, new UserMapper(), offset, limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "Select Count(*) from tbluser";
		return count(sql);
	}

	@Override
	public UserModel findOne(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tbluser WHERE user_id=?";
		List<UserModel> users = query(sql, new UserMapper(), id);

		return users.isEmpty() ? null : users.get(0);
	}

}
