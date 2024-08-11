package Model;

public class TraCuuBaoCao {
	private String tenLop;
	private int siSo;
	private int slDat;
	private float tiLe;
	public TraCuuBaoCao(String tenLop, int siSo, int slDat, float tiLe) {
		super();
		this.tenLop = tenLop;
		this.siSo = siSo;
		this.slDat = slDat;
		this.tiLe = tiLe;
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
	public int getSlDat() {
		return slDat;
	}
	public void setSlDat(int slDat) {
		this.slDat = slDat;
	}
	public float getTiLe() {
		return tiLe;
	}
	public void setTiLe(float tiLe) {
		this.tiLe = tiLe;
	}
	
	
}
