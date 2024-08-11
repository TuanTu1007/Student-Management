package Model;

public class LoaiHinhKiemTra {
	private String maLHKT;
	private String tenLHKT;
	private int heSo;
	public LoaiHinhKiemTra(String maLHKT, String tenLHKT, int heSo) {
		super();
		this.maLHKT = maLHKT;
		this.tenLHKT = tenLHKT;
		this.heSo = heSo;
	}
	public String getMaLHKT() {
		return maLHKT;
	}
	public void setMaLHKT(String maLHKT) {
		this.maLHKT = maLHKT;
	}
	public String getTenLHKT() {
		return tenLHKT;
	}
	public void setTenLHKT(String tenLHKT) {
		this.tenLHKT = tenLHKT;
	}
	public int getHeSo() {
		return heSo;
	}
	public void setHeSo(int heSo) {
		this.heSo = heSo;
	}
	
}
