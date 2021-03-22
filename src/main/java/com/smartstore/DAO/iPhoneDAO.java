package com.smartstore.DAO;

import java.util.List;

import com.smartstore.model.PhoneModel;
import com.smartstore.model.UserModel;
import com.smartstore.model.YeuThichModel;

public interface iPhoneDAO extends GenericDAO<PhoneModel> {
	List<PhoneModel> findAll();

	Long save(PhoneModel pm);

	void update(PhoneModel update);

	void delete(Long id);

	List<PhoneModel> findAll2(Integer offset, Integer limit);

	int getTotalItem();
	PhoneModel findOne(Long id);
	List<PhoneModel> findAllbyhangId(Integer offset,Integer limit,Long hangid);
}
