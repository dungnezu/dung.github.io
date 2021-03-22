package com.smartstore.DAO;

import java.util.List;

import com.smartstore.model.YeuThichModel;

public interface iYeuThichDAO extends GenericDAO<YeuThichModel> {
	List<YeuThichModel> findAll();

	Long save(YeuThichModel ym);

	void update(YeuThichModel update);

	void delete(Long id);

	List<YeuThichModel> findAll2(Integer offset, Integer limit);

	int getTotalItem();
}
