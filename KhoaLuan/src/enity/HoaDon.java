package enity;

import java.util.Date;
import java.util.List;


public class HoaDon {
	private long id;
	private Float tongTien;
	private PhieuKhambenh phieukhambenh;

	private Date ngayTao;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Float getTongTien() {
		return tongTien;
	}

	public void setTongTien(Float tongTien) {
		this.tongTien = tongTien;
	}

	public PhieuKhambenh getPhieukhambenh() {
		return phieukhambenh;
	}

	public void setPhieukhambenh(PhieuKhambenh phieukhambenh) {
		this.phieukhambenh = phieukhambenh;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
