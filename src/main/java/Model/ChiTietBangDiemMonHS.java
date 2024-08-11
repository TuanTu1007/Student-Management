package Model;

public class ChiTietBangDiemMonHS {
	private String MaCTBDMHS;
	private String MaBangDiemMon;
	private String MaHS;
	private double DiemTBMon;
	public ChiTietBangDiemMonHS(String maCTBDMHS, String maBangDiemMon, String maHS, double diemTBMon) {
		MaCTBDMHS = maCTBDMHS;
		MaBangDiemMon = maBangDiemMon;
		MaHS = maHS;
		DiemTBMon = diemTBMon;
	}
	public String getMaCTBDMHS() {
		return MaCTBDMHS;
	}
	public void setMaCTBDMHS(String maCTBDMHS) {
		MaCTBDMHS = maCTBDMHS;
	}
	public String getMaBangDiemMon() {
		return MaBangDiemMon;
	}
	public void setMaBangDiemMon(String maBangDiemMon) {
		MaBangDiemMon = maBangDiemMon;
	}
	public String getMaHS() {
		return MaHS;
	}
	public void setMaHS(String maHS) {
		MaHS = maHS;
	}
	public double getDiemTBMon() {
		return DiemTBMon;
	}
	public void setDiemTBMon(double diemTBMon) {
		DiemTBMon = diemTBMon;
	}
	
}
