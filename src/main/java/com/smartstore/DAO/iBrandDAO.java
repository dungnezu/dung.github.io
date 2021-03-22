package com.smartstore.DAO;

import java.util.List;

import com.smartstore.model.BrandModel;
import com.smartstore.model.UserModel;
import com.smartstore.model.YeuThichModel;

public interface iBrandDAO extends GenericDAO<BrandModel> {
	List<BrandModel> findAll();

	Long save(BrandModel bm);

	void update(BrandModel update);

	void delete(Long id);

	List<BrandModel> findAll2(Integer offset, Integer limit);

	int getTotalItem();
	
	BrandModel findOne(Long id);

}
