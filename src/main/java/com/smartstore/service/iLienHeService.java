package com.smartstore.service;

import java.util.List;

import com.smartstore.model.LienHeModel;

public interface iLienHeService {
	List<LienHeModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
	
}
