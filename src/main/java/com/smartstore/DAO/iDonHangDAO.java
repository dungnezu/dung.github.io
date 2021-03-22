package com.smartstore.DAO;

import java.util.List;

import com.smartstore.model.DonHangModel;
import com.smartstore.model.UserModel;
import com.smartstore.model.YeuThichModel;

public interface iDonHangDAO extends GenericDAO<DonHangModel> {
	List<DonHangModel> findAll();

	Long save(DonHangModel dhm);

	void update(DonHangModel update);

	void delete(Long id);

	List<DonHangModel> findAll2(Integer offset, Integer limit);

	int getTotalItem();
}
