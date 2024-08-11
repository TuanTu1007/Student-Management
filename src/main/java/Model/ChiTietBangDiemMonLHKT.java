package Model;

public class ChiTietBangDiemMonLHKT {
	private String MaCTBDM;
	private String MaLHKT;
	private double Diem;
	public ChiTietBangDiemMonLHKT(String maCTBDM, String maLHKT, double diem) {
		MaCTBDM = maCTBDM;
		MaLHKT = maLHKT;
		Diem = diem;
	}
	public String getMaCTBDM() {
		return MaCTBDM;
	}
	public void setMaCTBDM(String maCTBDM) {
		MaCTBDM = maCTBDM;
	}
	public String getMaLHKT() {
		return MaLHKT;
	}
	public void setMaLHKT(String maLHKT) {
		MaLHKT = maLHKT;
	}
	public double getDiem() {
		return Diem;
	}
	public void setDiem(double diem) {
		Diem = diem;
	}
	
	
}
