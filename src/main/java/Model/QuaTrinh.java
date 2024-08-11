package Model;

public class QuaTrinh {
	private String maHS;
	private String maLop;
	private String maHK;
	private float diemTBHK;
	public QuaTrinh(String maHS, String maLop, String maHK, float diemTBHK) {
		super();
		this.maHS = maHS;
		this.maLop = maLop;
		this.maHK = maHK;
		this.diemTBHK = diemTBHK;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getMaHK() {
		return maHK;
	}
	public void setMaHK(String maHK) {
		this.maHK = maHK;
	}
	public float getDiemTBHK() {
		return diemTBHK;
	}
	public void setDiemTBHK(float diemTBHK) {
		this.diemTBHK = diemTBHK;
	}
	
	
}
