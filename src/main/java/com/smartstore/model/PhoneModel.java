package com.smartstore.model;

import java.util.List;

public class PhoneModel  extends AbstractModel<PhoneModel>{
	private Long dt_id;
	private String dt_ten;
	private String dt_gia;
	private String dt_manhinh;
	private String dt_camsau;
	private String dt_camtruoc;
	private String dt_mausac1;

	private String dt_chip;
	private String dt_ram;
	private String dt_rom;
	private String dt_sim;
	private String dt_baomat;
	private String dt_pin;
	private String dt_phukien;
	private String dt_anh1;

	private String dt_motangan;
	
	private Long dt_hang_id;

	private BrandModel hang = new BrandModel();

	public Long getDt_id() {
		return dt_id;
	}

	public void setDt_id(Long dt_id) {
		this.dt_id = dt_id;
	}

	public Long getDt_hang_id() {
		return dt_hang_id;
	}

	public void setDt_hang_id(Long dt_hang_id) {
		this.dt_hang_id = dt_hang_id;
	}

	public String getDt_manhinh() {
		return dt_manhinh;
	}

	public void setDt_manhinh(String dt_manhinh) {
		this.dt_manhinh = dt_manhinh;
	}

	public String getDt_camsau() {
		return dt_camsau;
	}

	public void setDt_camsau(String dt_camsau) {
		this.dt_camsau = dt_camsau;
	}

	public String getDt_camtruoc() {
		return dt_camtruoc;
	}

	public void setDt_camtruoc(String dt_camtruoc) {
		this.dt_camtruoc = dt_camtruoc;
	}

	public String getDt_mausac1() {
		return dt_mausac1;
	}

	public void setDt_mausac1(String dt_mausac1) {
		this.dt_mausac1 = dt_mausac1;
	}



	public String getDt_chip() {
		return dt_chip;
	}

	public void setDt_chip(String dt_chip) {
		this.dt_chip = dt_chip;
	}

	public String getDt_ram() {
		return dt_ram;
	}

	public void setDt_ram(String dt_ram) {
		this.dt_ram = dt_ram;
	}

	public String getDt_rom() {
		return dt_rom;
	}

	public void setDt_rom(String dt_rom) {
		this.dt_rom = dt_rom;
	}

	public String getDt_sim() {
		return dt_sim;
	}

	public void setDt_sim(String dt_sim) {
		this.dt_sim = dt_sim;
	}

	public String getDt_baomat() {
		return dt_baomat;
	}

	public void setDt_baomat(String dt_baomat) {
		this.dt_baomat = dt_baomat;
	}

	public String getDt_pin() {
		return dt_pin;
	}

	public void setDt_pin(String dt_pin) {
		this.dt_pin = dt_pin;
	}

	public String getDt_phukien() {
		return dt_phukien;
	}

	public void setDt_phukien(String dt_phukien) {
		this.dt_phukien = dt_phukien;
	}

	public String getDt_anh1() {
		return dt_anh1;
	}

	public void setDt_anh1(String dt_anh1) {
		this.dt_anh1 = dt_anh1;
	}



	public String getDt_motangan() {
		return dt_motangan;
	}

	public void setDt_motangan(String dt_motangan) {
		this.dt_motangan = dt_motangan;
	}

	public BrandModel getHang() {
		return hang;
	}

	public void setHang(BrandModel hang) {
		this.hang = hang;
	}

	public String getDt_ten() {
		return dt_ten;
	}

	public void setDt_ten(String dt_ten) {
		this.dt_ten = dt_ten;
	}

	public String getDt_gia() {
		return dt_gia;
	}

	public void setDt_gia(String dt_gia) {
		this.dt_gia = dt_gia;
	}

	

}
