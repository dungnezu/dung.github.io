package com.smartstore.service;

import java.util.List;

import com.smartstore.model.GiohangModel;

public interface iGioHangService {
	List<GiohangModel> findAll(Integer offset, Integer limit ,Long id);
	int getTotalItem();
	GiohangModel insert(GiohangModel ghm);
	GiohangModel update(GiohangModel ghm);
	void delete(Long ghid, Long dtid);
	List<GiohangModel> findAll2(Integer offset, Integer limit);
	GiohangModel findOne(Long id);
}
