package com.smartstore.DAO.impl;

import java.util.List;

import com.smartstore.DAO.iLienHeDAO;
import com.smartstore.mapper.LienHeMapper;
import com.smartstore.model.LienHeModel;

public class LienHeDAO extends AbstractDAO<LienHeModel> implements iLienHeDAO {



	@Override
	public Long save(LienHeModel lhm) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tbllienhe(lh_hoten,lh_email,lh_sodt,lh_noidung)VALUES(?,?,?,?)";
		return insert(sql, lhm.getLh_hoten(),lhm.getLh_email(),lhm.getLh_sodt(),lhm.getLh_noidung());
	}



	@Override
	public List<LienHeModel> findAll2(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		String sql="select * from tbllienhe LIMIT ?,?";
		return query(sql, new LienHeMapper(), offset,limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "Select Count(*) from tbllienhe";
		return count(sql);
	}

}
