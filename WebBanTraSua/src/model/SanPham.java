package model;

public class SanPham {
	private String masp;
	private String tensp;
	private String hinhanh;
	private double gia;
	public SanPham(String masp, String tensp, String hinhanh, double gia) {
		this.masp = masp;
		this.tensp = tensp;
		this.hinhanh = hinhanh;
		this.gia = gia;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	
}
