package com.smartstore.DAO.impl;

import java.util.List;

import com.smartstore.DAO.iGioHangDAO;
import com.smartstore.mapper.GioHangMapper;
import com.smartstore.model.GiohangModel;

public class GioHangDAO extends AbstractDAO<GiohangModel> implements iGioHangDAO{

	@Override
	public List<GiohangModel> findALl() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblgiohang";
		return query(sql, new GioHangMapper() );
	}

	@Override
	public Long save(GiohangModel ghm) {
		// TODO Auto-generated method stub
		String sql="insert into tblgiohang(gh_dt_id,gh_user_id,gh_gia,gh_soluongmua,gh_tongtien) value(?,?,?,?,?);";
		return insert(sql, ghm.getGh_dt_id(),ghm.getGh_user_id(),ghm.getGh_gia(),ghm.getGh_soluongmua(),ghm.getGh_tongtien());
	}

	@Override
	public void update(GiohangModel update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long ghid,Long dtid) {
		String sql = "DELETE FROM tblgiohang WHERE gh_id = ? and gh_dt_id =?";
		delete(sql, ghid,dtid);
		
	}

	@Override
	public List<GiohangModel> findAll2(Integer offset, Integer limit ,Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblgiohang as g inner join tblphone as p on g.gh_dt_id=p.dt_id inner join tbluser as u on g.gh_user_id=u.user_id where g.gh_user_id=? LIMIT ?,?";
		return query(sql, new GioHangMapper(), id,offset, limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "Select Count(*) from tblgiohang";
		return count(sql);
	}

	@Override
	public GiohangModel findOne(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblgiohang as g inner join tblphone as p on g.gh_dt_id=p.dt_id inner join tbluser as u on g.gh_user_id=u.user_id where g.gh_id=?";
		List<GiohangModel> ghs=query(sql,new GioHangMapper(), id);
		return ghs.isEmpty() ? null : ghs.get(0);
	}

	@Override
	public List<GiohangModel> findAll(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblgiohang as g inner join tblphone as p on g.gh_dt_id=p.dt_id inner join tbluser as u on g.gh_user_id=u.user_id  LIMIT ?,?";
		return query(sql, new GioHangMapper(),offset, limit);
	}

}
