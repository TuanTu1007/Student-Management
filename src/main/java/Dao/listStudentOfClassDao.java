package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.Statement;

import Model.HocSinh;
import Model.LoaiHinhKiemTra;
import Model.Mon;

public class listStudentOfClassDao {
	private DataSource datasource;

	public listStudentOfClassDao(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<HocSinh> listStudenNotClass() {
		List<HocSinh> DSHS = new ArrayList<>();
		try (Connection connection = datasource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT *\r\n" + "FROM hocsinh\r\n"
						+ "LEFT JOIN quatrinh ON hocsinh.mahs = quatrinh.mahs \r\n" + "WHERE quatrinh.mahs IS NULL;")) {
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String namsinh = rs.getString(4).substring(0,10);
				String address = rs.getString(5);
				String email = rs.getString(6);

				HocSinh hs = new HocSinh(id, name, gender, namsinh, address, email);
				DSHS.add(hs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DSHS;
	}

	public List<HocSinh> renderStudentOfClass(String nameClass) {
		List<HocSinh> DSHS = new ArrayList<>();
		String SELECT_STUDENT_OF_CLASS = "SELECT DISTINCT hs.MaHS, hs.TenHS, hs.GioiTinh, hs.NamSinh, hs.DiaChi, hs.Email "
				+ "FROM quatrinh qt, lop l, hocsinh hs "
				+ "WHERE qt.MaLop = l.MaLop AND qt.MaHS = hs.MaHS AND l.TenLop = ?";
		try (Connection connection = datasource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_OF_CLASS)) {
			statement.setString(1, nameClass);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					String maHS = rs.getString(1);
					String tenHS = rs.getString(2);
					String gioiTinh = rs.getString(3);
					String namSinh = rs.getString(4).substring(0,10);
					String diaChi = rs.getString(5);
					String email = rs.getString(6);

					HocSinh hs = new HocSinh(maHS, tenHS, gioiTinh, namSinh, diaChi, email);
					DSHS.add(hs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DSHS;
	}

	public int selectSiSo(String nameClass) {
		int siso = 0;
		String SELECT_STUDENT_OF_CLASS = "SELECT lop.siso " + "FROM lop " + "WHERE lop.TenLop = ?;";
		try (Connection connection = datasource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_OF_CLASS)) {
			statement.setString(1, nameClass);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				siso = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return siso;
	}
	
	public boolean addStdNotClassToClass(String[] listStdIdSelected, String nameClass) throws ClassNotFoundException {
		String ADD_STUDENT_TO_CLASS = "INSERT INTO QUATRINH VALUES (?,?,?,?);";
		String classID = selectClassIDbyName(nameClass);
		String hk1 = "HK1";
		boolean isvalid = false;
		try (Connection connection = datasource.getConnection();
				PreparedStatement statement = connection.prepareStatement(ADD_STUDENT_TO_CLASS)) {
			int count = 0;
			for (String part : listStdIdSelected) {			

				statement.setString(1, part);
				statement.setString(2, classID);
				statement.setString(3, hk1);
				statement.setString(4, null);
				statement.executeUpdate();
				count++;
			}

			if (count > 0) {
				isvalid = true;
			} else {
				isvalid = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isvalid;
	}
	
	// hàm tạo bảng bảng điểm môn
		public void createTablePointEmpty(String[] listStdIdSelected, String nameClass, List<Mon> DSMH)
				throws ClassNotFoundException {
			String sql = "INSERT INTO BANGDIEMMON VALUES (?,?,?,?,?);";
			String classID = selectClassIDbyName(nameClass);
			String hk1 = "HK1";
			try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
				// part is MaHS
				for (String part : listStdIdSelected) {
					for (int i = 0; i < DSMH.size(); i++) {
						statement.setString(1, part + "-" + DSMH.get(i).getMaMH() + "-" + hk1);
						statement.setString(2, "NH1");
						statement.setString(3, classID);
						statement.setString(4, DSMH.get(i).getMaMH());
						statement.setString(5, hk1);
						statement.executeUpdate();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// hàm tạo bảng chi tiết bảng điểm môn
		public void createCTTablePointEmpty(String[] listStdIdSelected, List<Mon> DSMH) throws ClassNotFoundException {
			String sql = "INSERT INTO CT_BANGDIEMMON_HS VALUES (?,?,?,?);";
			String hk1 = "HK1";
			try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
				// part is MaHS
				for (String part : listStdIdSelected) {
					for (int i = 0; i < DSMH.size(); i++) {
						statement.setString(1, "CT-" + part + "-" + DSMH.get(i).getMaMH() + "-" + hk1);
						statement.setString(2, part + "-" + DSMH.get(i).getMaMH() + "-" + hk1);
						statement.setString(3, part);
						statement.setString(4, null);
						statement.executeUpdate();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// hàm tạo bảng chi tiết loại hình kiểm tra
		public void createCTLHKTEmpty(String[] listStdIdSelected, List<Mon> DSMH, List<LoaiHinhKiemTra> DSLHKT)
				throws ClassNotFoundException {
			String sql = "INSERT INTO CT_BANGDIEMMON_LHKT VALUES (?,?,?);";
			String hk1 = "HK1";
			try (Connection connection = datasource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
				// part is MaHS
				for (String part : listStdIdSelected) {
					for (int i = 0; i < DSMH.size(); i++) {
						for (int e = 0; e < DSLHKT.size(); e++) {
							statement.setString(1, "CT-" + part + "-" + DSMH.get(i).getMaMH() + "-" + hk1);
							statement.setString(2, DSLHKT.get(e).getMaLHKT());
							statement.setFloat(3, 0);
							statement.executeUpdate();
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	public String selectClassIDbyName(String name) throws ClassNotFoundException {
		String SELECT_ID_BY_NAME = "SELECT MaLop FROM lop WHERE TenLop = ?";
		String classID = "";
		try (Connection connection = datasource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_ID_BY_NAME)) {
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				classID = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classID;
	}  

	public String[] selectStdIDByEmail(String[] input) throws ClassNotFoundException {
		String SELECT_STUDENT_BY_EMAIL = "SELECT MaHS FROM hocsinh where Email = ?";
		String students = "";
		try (Connection connection = datasource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_EMAIL)) {
			for (String part : input) {
				statement.setString(1, part);
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					String maHS = rs.getString(1);
					students += maHS + ",";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return splitStringByComma(students);
	}

	public String[] splitStringByComma(String input) {
		if (input == null || input.isEmpty()) {
			return new String[0];
		}
		return input.split(",");
	}

}
