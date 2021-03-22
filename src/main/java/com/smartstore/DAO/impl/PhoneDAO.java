package com.smartstore.DAO.impl;

import java.util.List;

import com.smartstore.DAO.iPhoneDAO;
import com.smartstore.mapper.BrandMapper;
import com.smartstore.mapper.PhoneMapper;
import com.smartstore.mapper.UserMapper;
import com.smartstore.model.BrandModel;
import com.smartstore.model.PhoneModel;

public class PhoneDAO extends AbstractDAO<PhoneModel> implements iPhoneDAO {

	@Override
	public List<PhoneModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(PhoneModel pm) {
		// TODO Auto-generated method stub
		String sql = "insert into tblphone(dt_ten,dt_gia,dt_manhinh,dt_camsau,dt_camtruoc,dt_mausac1,dt_chip,dt_ram,dt_rom,dt_sim,dt_baomat,dt_pin,dt_phukien,dt_anh1,dt_motangan,dt_hang_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql, pm.getDt_ten(),pm.getDt_gia(),pm.getDt_manhinh(),pm.getDt_camsau(),pm.getDt_camtruoc(),pm.getDt_mausac1()
				,pm.getDt_chip(),pm.getDt_ram(),pm.getDt_rom(),pm.getDt_sim(),pm.getDt_baomat(),pm.getDt_pin(),pm.getDt_phukien(),
				pm.getDt_anh1(),pm.getDt_motangan(),pm.getDt_hang_id());
	}

	@Override
	public void update(PhoneModel pm) {
		// TODO Auto-generated method stub
		String sql = "update tblphone set dt_ten=?,dt_gia=?, dt_manhinh=?, dt_camsau=?,  dt_camtruoc=?, dt_mausac1=?, dt_chip=?, dt_ram=?, dt_rom=?, dt_sim=?, dt_baomat=?, dt_pin=?, dt_phukien=?, dt_anh1=?, dt_motangan=?, dt_hang_id=? where dt_id=?";

		update(sql,pm.getDt_ten(),pm.getDt_gia(),pm.getDt_manhinh(),pm.getDt_camsau(),pm.getDt_camtruoc(),pm.getDt_mausac1(),pm.getDt_chip(),pm.getDt_ram(),pm.getDt_rom(),pm.getDt_sim(),pm.getDt_baomat(),pm.getDt_pin(),pm.getDt_phukien(),pm.getDt_anh1(),pm.getDt_motangan(),pm.getDt_hang_id(),pm.getId() );
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tblphone WHERE dt_id=?";
		delete(sql, id);
	}

	@Override
	public List<PhoneModel> findAll2(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblphone AS p INNER JOIN tblhangdt AS h ON p.dt_hang_id = h.hang_id  "
				+ "LIMIT ?,?";
		return query(sql, new PhoneMapper(), offset, limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		String sql = "Select Count(*) from tblphone";
		return count(sql);
	}

	@Override
	public PhoneModel findOne(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblPhone WHERE dt_id=?";
		List<PhoneModel> phones = query(sql.toString(), new PhoneMapper(), id);

		return phones.isEmpty() ? null : phones.get(0);
	}

	@Override
	public List<PhoneModel> findAllbyhangId(Integer offset, Integer limit, Long hangid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblphone AS p INNER JOIN tblhangdt AS h ON p.dt_hang_id = h.hang_id where p.dt_hang_id=? "
				+ "LIMIT ?,?";
		return query(sql, new PhoneMapper(),hangid, offset, limit);
	}

}
