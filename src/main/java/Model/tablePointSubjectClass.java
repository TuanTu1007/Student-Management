package Model;

public class tablePointSubjectClass {
	private String tenHS;
	private float mieng;
	private float muoiLamPhut;
	private float motTiet;
	private float hocKy;
	private float tbMon;
	public tablePointSubjectClass(String tenHS, float mieng, float muoiLamPhut, float motTiet, float hocKy,
			float tbMon) {
		super();
		this.tenHS = tenHS;
		this.mieng = mieng;
		this.muoiLamPhut = muoiLamPhut;
		this.motTiet = motTiet;
		this.hocKy = hocKy;
		this.tbMon = tbMon;
	}
	public String getTenHS() {
		return tenHS;
	}
	public void setTenHS(String tenHS) {
		this.tenHS = tenHS;
	}
	public float getMieng() {
		return mieng;
	}
	public void setMieng(float mieng) {
		this.mieng = mieng;
	}
	public float getMuoiLamPhut() {
		return muoiLamPhut;
	}
	public void setMuoiLamPhut(float muoiLamPhut) {
		this.muoiLamPhut = muoiLamPhut;
	}
	public float getMotTiet() {
		return motTiet;
	}
	public void setMotTiet(float motTiet) {
		this.motTiet = motTiet;
	}
	public float getHocKy() {
		return hocKy;
	}
	public void setHocKy(float hocKy) {
		this.hocKy = hocKy;
	}
	public float getTbMon() {
		return tbMon;
	}
	public void setTbMon(float tbMon) {
		this.tbMon = tbMon;
	}
	
	
}
