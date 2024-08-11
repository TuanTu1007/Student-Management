package Model;

public class ChiTietBaoCaoTongKetMon {
	private String MaBCTKM;
	private String MaLop;
	private int SiSo;
	private int SLDat;
	private double TiLe;
	public ChiTietBaoCaoTongKetMon(String maBCTKM, String maLop, int siSo, int sLDat, double tiLe) {
		MaBCTKM = maBCTKM;
		MaLop = maLop;
		SiSo = siSo;
		SLDat = sLDat;
		TiLe = tiLe;
	}
	public String getMaBCTKM() {
		return MaBCTKM;
	}
	public void setMaBCTKM(String maBCTKM) {
		MaBCTKM = maBCTKM;
	}
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
	}
	public int getSiSo() {
		return SiSo;
	}
	public void setSiSo(int siSo) {
		SiSo = siSo;
	}
	public int getSLDat() {
		return SLDat;
	}
	public void setSLDat(int sLDat) {
		SLDat = sLDat;
	}
	public double getTiLe() {
		return TiLe;
	}
	public void setTiLe(double tiLe) {
		TiLe = tiLe;
	}
	
	
}
