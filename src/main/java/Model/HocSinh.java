package Model;

public class HocSinh {
	private String maHS;
	private String tenHS;
	private String gioiTinh;
	private String namSinh;
	private String diaChi;
	private String email;
	public HocSinh(String maHS, String tenHS, String gioiTinh, String namSinh, String diaChi, String email) {
		super();
		this.maHS = maHS;
		this.tenHS = tenHS;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.email = email;
	}
	public HocSinh() {
		
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public String getTenHS() {
		return tenHS;
	}
	public void setTenHS(String tenHS) {
		this.tenHS = tenHS;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
