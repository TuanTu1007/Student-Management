package Model;

public class NamHoc {
	private String MaNH;
	private int NamBatDau;
	private int NamKetThuc;
	public NamHoc(String maNH, int namBatDau, int namKetThuc) {
		MaNH = maNH;
		NamBatDau = namBatDau;
		NamKetThuc = namKetThuc;
	}
	public String getMaNH() {
		return MaNH;
	}
	public void setMaNH(String maNH) {
		MaNH = maNH;
	}
	public int getNamBatDau() {
		return NamBatDau;
	}
	public void setNamBatDau(int namBatDau) {
		NamBatDau = namBatDau;
	}
	public int getNamKetThuc() {
		return NamKetThuc;
	}
	public void setNamKetThuc(int namKetThuc) {
		NamKetThuc = namKetThuc;
	}
	
	
}
