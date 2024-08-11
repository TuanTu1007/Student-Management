package Model;

public class BaoCaoTongKetHocKy {
	private String MaHK;
	private String MaNH;
	private String MaLop;
	private int SiSo;
	private int SLDat;
	private double TiLe;
	public BaoCaoTongKetHocKy(String maHK, String maNH, String maLop, int siSo, int sLDat, double tiLe) {
		MaHK = maHK;
		MaNH = maNH;
		MaLop = maLop;
		SiSo = siSo;
		SLDat = sLDat;
		TiLe = tiLe;
	}
	public String getMaHK() {
		return MaHK;
	}
	public void setMaHK(String maHK) {
		MaHK = maHK;
	}
	public String getMaNH() {
		return MaNH;
	}
	public void setMaNH(String maNH) {
		MaNH = maNH;
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
