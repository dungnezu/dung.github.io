package com.smartstore.service;

import java.util.List;

import com.smartstore.model.BrandModel;

public interface iBrandService {
	List<BrandModel> findAll();

	BrandModel findOne(Long id);
}
