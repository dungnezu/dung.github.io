package com.smartstore.DAO;

import java.util.List;

import com.smartstore.model.LienHeModel;
import com.smartstore.model.UserModel;
import com.smartstore.model.YeuThichModel;

public interface iLienHeDAO extends GenericDAO<LienHeModel> {
	
	Long save(LienHeModel lhm);

	List<LienHeModel> findAll2(Integer offset, Integer limit);

	int getTotalItem();
}
