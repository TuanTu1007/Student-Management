package Model;

public class Mon {
	private String maMH;
	private String tenMH;
	private int heSo;
	public Mon(String maMH, String tenMH, int heSo) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.heSo = heSo;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public int getHeSo() {
		return heSo;
	}
	public void setHeSo(int heSo) {
		this.heSo = heSo;
	}
	
	public Mon() {
		
	}
	
}
