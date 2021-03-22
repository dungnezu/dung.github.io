package com.smartstore.DAO.impl;

import java.util.List;

import com.smartstore.DAO.iDonHangDAO;
import com.smartstore.mapper.DonHangMapper;
import com.smartstore.mapper.GioHangMapper;
import com.smartstore.mapper.RowMapper;
import com.smartstore.model.DonHangModel;

public class DonHangDAO extends AbstractDAO<DonHangModel> implements iDonHangDAO {

	@Override
	public List<DonHangModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(DonHangModel dhm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DonHangModel update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DonHangModel> findAll2(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		String sql="select * from tbldonhang as d inner join tblgiohang as g on d.gh_id=g.gh_id inner join tbluser as u on d.dh_user_id=u.user_id limit ?,?";
		return query(sql, new DonHangMapper(), offset,limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "Select Count(*) from tbldonhang";
		return count(sql);
	}

	

}
