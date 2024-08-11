package Model;

public class ChangeRule {
    private int tuoiHSToiDa;
    private int tuoiHSToiThieu;
    private int soLuongHSToiDa;
    private int diemToiDa;
    private int diemToiThieu;
    private int diemDat;
    private String columnName;
    private int value;

    public ChangeRule(String columnName, int value) {
        this.columnName = columnName;
        this.value = value;
    }

    public String getColumnName() {
        return columnName;
    }

    public int getValue() {
        return value;
    }
	public ChangeRule(int tuoiHSToiDa, int tuoiHSToiThieu, int soLuongHSToiDa, int diemToiDa, int diemToiThieu,
			int diemDat) {
		super();
		this.tuoiHSToiDa = tuoiHSToiDa;
		this.tuoiHSToiThieu = tuoiHSToiThieu;
		this.soLuongHSToiDa = soLuongHSToiDa;
		this.diemToiDa = diemToiDa;
		this.diemToiThieu = diemToiThieu;
		this.diemDat = diemDat;
	}
	public int getTuoiHSToiDa() {
		return tuoiHSToiDa;
	}
	public void setTuoiHSToiDa(int tuoiHSToiDa) {
		this.tuoiHSToiDa = tuoiHSToiDa;
	}
	public int getTuoiHSToiThieu() {
		return tuoiHSToiThieu;
	}
	public void setTuoiHSToiThieu(int tuoiHSToiThieu) {
		this.tuoiHSToiThieu = tuoiHSToiThieu;
	}
	public int getSoLuongHSToiDa() {
		return soLuongHSToiDa;
	}
	public void setSoLuongHSToiDa(int soLuongHSToiDa) {
		this.soLuongHSToiDa = soLuongHSToiDa;
	}
	public int getDiemToiDa() {
		return diemToiDa;
	}
	public void setDiemToiDa(int diemToiDa) {
		this.diemToiDa = diemToiDa;
	}
	public int getDiemToiThieu() {
		return diemToiThieu;
	}
	public void setDiemToiThieu(int diemToiThieu) {
		this.diemToiThieu = diemToiThieu;
	}
	public int getDiemDat() {
		return diemDat;
	}
	public void setDiemDat(int diemDat) {
		this.diemDat = diemDat;
	}
    
}
