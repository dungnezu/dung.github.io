package com.smartstore.DAO;

import java.util.List;

import com.smartstore.model.chitietDonHangModel;

public interface iChitietDonHangDAO extends GenericDAO<chitietDonHangModel>{

	List<chitietDonHangModel> findAll();

	Long save(chitietDonHangModel ctdh);

	void update(chitietDonHangModel ctdh);

	void delete(Long dh_id,Long dt_id);

	List<chitietDonHangModel> findAll2(Integer offset, Integer limit);

	int getTotalItem();
}
