package Model;

public class TraCuuHocSinh {
	private String tenHS;
	private String lop;
	private float tbhk1;
	private float tbhk2;
	public TraCuuHocSinh(String tenHS, String lop, float tbhk1, float tbhk2) {
		super();
		this.tenHS = tenHS;
		this.lop = lop;
		this.tbhk1 = tbhk1;
		this.tbhk2 = tbhk2;
	}
	public String getTenHS() {
		return tenHS;
	}
	public void setTenHS(String tenHS) {
		this.tenHS = tenHS;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public float getTbhk1() {
		return tbhk1;
	}
	public void setTbhk1(float tbhk1) {
		this.tbhk1 = tbhk1;
	}
	public float getTbhk2() {
		return tbhk2;
	}
	public void setTbhk2(float tbhk2) {
		this.tbhk2 = tbhk2;
	}
}
