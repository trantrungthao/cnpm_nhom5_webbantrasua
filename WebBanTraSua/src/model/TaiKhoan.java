package model;

public class TaiKhoan {
	private String tendangnhap;
	private String matkhau;
	private String hovaten;
	private String sdt;
	private String email;
	private String role;
	public TaiKhoan(String tendangnhap, String matkhau, String hovaten, String sdt, String email, String role) {
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.hovaten = hovaten;
		this.sdt = sdt;
		this.email = email;
		this.role = role;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getHovaten() {
		return hovaten;
	}
	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
