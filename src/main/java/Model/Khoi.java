package Model;

public class Khoi {
	private String MaKhoi;
	private String TenKhoi;
	public Khoi(String maKhoi, String tenKhoi) {
		super();
		MaKhoi = maKhoi;
		TenKhoi = tenKhoi;
	}
	public String getMaKhoi() {
		return MaKhoi;
	}
	public void setMaKhoi(String maKhoi) {
		MaKhoi = maKhoi;
	}
	public String getTenKhoi() {
		return TenKhoi;
	}
	public void setTenKhoi(String tenKhoi) {
		TenKhoi = tenKhoi;
	}
	
}
