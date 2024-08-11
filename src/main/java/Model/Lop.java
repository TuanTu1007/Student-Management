package Model;

public class Lop {
	private String maLop;
	private String tenLop;
	private int siSo;
	private String maKhoi;
	private String maNH;
	public Lop(String maLop, String tenLop, int siSo, String maKhoi, String maNH) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.siSo = siSo;
		this.maKhoi = maKhoi;
		this.maNH = maNH;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public int getSiSo() {
		return siSo;
	}
	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}
	public String getMaKhoi() {
		return maKhoi;
	}
	public void setMaKhoi(String maKhoi) {
		this.maKhoi = maKhoi;
	}
	public String getMaNH() {
		return maNH;
	}
	public void setMaNH(String maNH) {
		this.maNH = maNH;
	}
	
	
}
