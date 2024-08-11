package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Model.PointAllSubject;

public class renderPointAllSubjectDao {
	private DataSource datasource;
	
	public renderPointAllSubjectDao(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<PointAllSubject> selectPointAllSubject (String nameClass, int hocKy) throws ClassNotFoundException, SQLException {
		List<PointAllSubject> listPointStudent = new ArrayList<>();
		String SELECT_TABLE_POINT = "SELECT \r\n"
				+ "    HOCSINH.TenHS,\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Toán' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Toán',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Lý' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Lý',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Hóa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Hóa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Anh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Anh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Văn' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Văn',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Thể dục' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Thể dục',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sinh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sinh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sử' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sử',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Địa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Địa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'GDCD' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'GDCD',\r\n"
				+ "    ROUND(QUATRINH.diemtbhk, 1),\r\n"
				+ "	   CASE \r\n"
				+ "		   WHEN QUATRINH.DiemTBHK >= 9 THEN 'Xuất Sắc'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 8 THEN 'Giỏi'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 6.5 THEN 'Khá'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 5 THEN 'Trung Bình'\r\n"
				+ "        ELSE 'Yếu'\r\n"
				+ "    END AS XepLoair\n"
				+ "FROM CT_BANGDIEMMON_HS\r\n"
				+ "JOIN BANGDIEMMON ON CT_BANGDIEMMON_HS.MaBangDiemMon = BANGDIEMMON.MaBangDiemMon\r\n"
				+ "JOIN MON ON BANGDIEMMON.MaMH = MON.MaMH\r\n"
				+ "JOIN HOCKY ON BANGDIEMMON.MaHK = HOCKY.MaHK\r\n"
				+ "JOIN HOCSINH ON CT_BANGDIEMMON_HS.MaHS = HOCSINH.MaHS\r\n"
				+ "JOIN QUATRINH ON HOCSINH.MaHS = QUATRINH.MaHS AND BANGDIEMMON.MaLop = QUATRINH.MaLop AND BANGDIEMMON.MaHK = QUATRINH.MaHK\r\n"
				+ "JOIN LOP ON QUATRINH.MaLop = LOP.MaLop\r\n"
				+ "where LOP.TenLop = ? and HOCKY.tenHK = ?\r\n"
				+ "GROUP BY HOCSINH.TenHS, QUATRINH.diemtbhk;";
		try (Connection connection = datasource.getConnection();
				Statement stmt = connection.createStatement();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TABLE_POINT);){
			preparedStatement.setString(1, nameClass);
			preparedStatement.setInt(2, hocKy);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PointAllSubject diem = new PointAllSubject(rs.getString(1),rs.getFloat(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8),rs.getFloat(9),rs.getFloat(10),rs.getFloat(11),rs.getFloat(12),rs.getString(13));
				listPointStudent.add(diem);
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return listPointStudent;
	}
	
	public List<PointAllSubject> renderTypeStudent (String phanLoai) throws ClassNotFoundException, SQLException {
		List<PointAllSubject> listTypeStudent = new ArrayList<>();
		String SELECT_EXCELLENT = "SELECT \r\n"
				+ "    HOCSINH.TenHS,\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Toán' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Toán',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Lý' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Lý',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Hóa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Hóa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Anh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Anh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Văn' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Văn',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Thể dục' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Thể dục',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sinh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sinh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sử' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sử',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Địa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Địa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'GDCD' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'GDCD',\r\n"
				+ "    ROUND(QUATRINH.diemtbhk, 1),\r\n"
				+ "	   CASE \r\n"
				+ "		   WHEN QUATRINH.DiemTBHK >= 9 THEN 'Xuất Sắc'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 8 THEN 'Giỏi'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 6.5 THEN 'Khá'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 5 THEN 'Trung Bình'\r\n"
				+ "        ELSE 'Yếu'\r\n"
				+ "    END AS XepLoair\n"
				+ "FROM CT_BANGDIEMMON_HS\r\n"
				+ "JOIN BANGDIEMMON ON CT_BANGDIEMMON_HS.MaBangDiemMon = BANGDIEMMON.MaBangDiemMon\r\n"
				+ "JOIN MON ON BANGDIEMMON.MaMH = MON.MaMH\r\n"
				+ "JOIN HOCKY ON BANGDIEMMON.MaHK = HOCKY.MaHK\r\n"
				+ "JOIN HOCSINH ON CT_BANGDIEMMON_HS.MaHS = HOCSINH.MaHS\r\n"
				+ "JOIN QUATRINH ON HOCSINH.MaHS = QUATRINH.MaHS AND BANGDIEMMON.MaLop = QUATRINH.MaLop AND BANGDIEMMON.MaHK = QUATRINH.MaHK\r\n"
				+ "JOIN LOP ON QUATRINH.MaLop = LOP.MaLop\r\n"
				+ "GROUP BY HOCSINH.TenHS, QUATRINH.diemtbhk\r\n"
				+ "HAVING QUATRINH.DiemTBHK >= 9;";
		
		String SELECT_GOOD = "SELECT \r\n"
				+ "    HOCSINH.TenHS,\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Toán' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Toán',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Lý' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Lý',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Hóa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Hóa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Anh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Anh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Văn' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Văn',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Thể dục' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Thể dục',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sinh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sinh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sử' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sử',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Địa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Địa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'GDCD' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'GDCD',\r\n"
				+ "    ROUND(QUATRINH.diemtbhk, 1),\r\n"
				+ "	   CASE \r\n"
				+ "		   WHEN QUATRINH.DiemTBHK >= 9 THEN 'Xuất Sắc'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 8 THEN 'Giỏi'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 6.5 THEN 'Khá'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 5 THEN 'Trung Bình'\r\n"
				+ "        ELSE 'Yếu'\r\n"
				+ "    END AS XepLoair\n"
				+ "FROM CT_BANGDIEMMON_HS\r\n"
				+ "JOIN BANGDIEMMON ON CT_BANGDIEMMON_HS.MaBangDiemMon = BANGDIEMMON.MaBangDiemMon\r\n"
				+ "JOIN MON ON BANGDIEMMON.MaMH = MON.MaMH\r\n"
				+ "JOIN HOCKY ON BANGDIEMMON.MaHK = HOCKY.MaHK\r\n"
				+ "JOIN HOCSINH ON CT_BANGDIEMMON_HS.MaHS = HOCSINH.MaHS\r\n"
				+ "JOIN QUATRINH ON HOCSINH.MaHS = QUATRINH.MaHS AND BANGDIEMMON.MaLop = QUATRINH.MaLop AND BANGDIEMMON.MaHK = QUATRINH.MaHK\r\n"
				+ "JOIN LOP ON QUATRINH.MaLop = LOP.MaLop\r\n"
				+ "GROUP BY HOCSINH.TenHS, QUATRINH.diemtbhk\r\n"
				+ "HAVING QUATRINH.DiemTBHK >= 8;";
		
		String SELECT_ELLs = "SELECT \r\n"
				+ "    HOCSINH.TenHS,\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Toán' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Toán',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Lý' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Lý',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Hóa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Hóa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Anh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Anh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Văn' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Văn',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Thể dục' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Thể dục',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sinh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sinh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sử' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sử',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Địa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Địa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'GDCD' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'GDCD',\r\n"
				+ "    ROUND(QUATRINH.diemtbhk, 1),\r\n"
				+ "	   CASE \r\n"
				+ "		   WHEN QUATRINH.DiemTBHK >= 9 THEN 'Xuất Sắc'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 8 THEN 'Giỏi'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 6.5 THEN 'Khá'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 5 THEN 'Trung Bình'\r\n"
				+ "        ELSE 'Yếu'\r\n"
				+ "    END AS XepLoair\n"
				+ "FROM CT_BANGDIEMMON_HS\r\n"
				+ "JOIN BANGDIEMMON ON CT_BANGDIEMMON_HS.MaBangDiemMon = BANGDIEMMON.MaBangDiemMon\r\n"
				+ "JOIN MON ON BANGDIEMMON.MaMH = MON.MaMH\r\n"
				+ "JOIN HOCKY ON BANGDIEMMON.MaHK = HOCKY.MaHK\r\n"
				+ "JOIN HOCSINH ON CT_BANGDIEMMON_HS.MaHS = HOCSINH.MaHS\r\n"
				+ "JOIN QUATRINH ON HOCSINH.MaHS = QUATRINH.MaHS AND BANGDIEMMON.MaLop = QUATRINH.MaLop AND BANGDIEMMON.MaHK = QUATRINH.MaHK\r\n"
				+ "JOIN LOP ON QUATRINH.MaLop = LOP.MaLop\r\n"
				+ "GROUP BY HOCSINH.TenHS, QUATRINH.diemtbhk\r\n"
				+ "HAVING QUATRINH.DiemTBHK >= 6.5;";
		
		String SELECT_AVERAGE = "SELECT \r\n"
				+ "    HOCSINH.TenHS,\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Toán' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Toán',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Lý' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Lý',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Hóa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Hóa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Anh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Anh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Văn' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Văn',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Thể dục' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Thể dục',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sinh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sinh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sử' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sử',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Địa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Địa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'GDCD' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'GDCD',\r\n"
				+ "    ROUND(QUATRINH.diemtbhk, 1),\r\n"
				+ "	   CASE \r\n"
				+ "		   WHEN QUATRINH.DiemTBHK >= 9 THEN 'Xuất Sắc'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 8 THEN 'Giỏi'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 6.5 THEN 'Khá'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 5 THEN 'Trung Bình'\r\n"
				+ "        ELSE 'Yếu'\r\n"
				+ "    END AS XepLoair\n"
				+ "FROM CT_BANGDIEMMON_HS\r\n"
				+ "JOIN BANGDIEMMON ON CT_BANGDIEMMON_HS.MaBangDiemMon = BANGDIEMMON.MaBangDiemMon\r\n"
				+ "JOIN MON ON BANGDIEMMON.MaMH = MON.MaMH\r\n"
				+ "JOIN HOCKY ON BANGDIEMMON.MaHK = HOCKY.MaHK\r\n"
				+ "JOIN HOCSINH ON CT_BANGDIEMMON_HS.MaHS = HOCSINH.MaHS\r\n"
				+ "JOIN QUATRINH ON HOCSINH.MaHS = QUATRINH.MaHS AND BANGDIEMMON.MaLop = QUATRINH.MaLop AND BANGDIEMMON.MaHK = QUATRINH.MaHK\r\n"
				+ "JOIN LOP ON QUATRINH.MaLop = LOP.MaLop\r\n"
				+ "GROUP BY HOCSINH.TenHS, QUATRINH.diemtbhk\r\n"
				+ "HAVING QUATRINH.DiemTBHK >= 5;";
		
		String SELECT_WEAK= "SELECT \r\n"
				+ "    HOCSINH.TenHS,\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Toán' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Toán',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Lý' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Lý',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Hóa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Hóa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Anh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Anh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Văn' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Văn',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Thể dục' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Thể dục',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sinh' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sinh',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Sử' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Sử',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'Địa' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'Địa',\r\n"
				+ "    ROUND(AVG(CASE WHEN MON.TenMH = 'GDCD' THEN CT_BANGDIEMMON_HS.DiemTBMon END), 1) AS 'GDCD',\r\n"
				+ "    ROUND(QUATRINH.diemtbhk, 1),\r\n"
				+ "	   CASE \r\n"
				+ "		   WHEN QUATRINH.DiemTBHK >= 9 THEN 'Xuất Sắc'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 8 THEN 'Giỏi'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 6.5 THEN 'Khá'\r\n"
				+ "        WHEN QUATRINH.DiemTBHK >= 5 THEN 'Trung Bình'\r\n"
				+ "        ELSE 'Yếu'\r\n"
				+ "    END AS XepLoair\n"
				+ "FROM CT_BANGDIEMMON_HS\r\n"
				+ "JOIN BANGDIEMMON ON CT_BANGDIEMMON_HS.MaBangDiemMon = BANGDIEMMON.MaBangDiemMon\r\n"
				+ "JOIN MON ON BANGDIEMMON.MaMH = MON.MaMH\r\n"
				+ "JOIN HOCKY ON BANGDIEMMON.MaHK = HOCKY.MaHK\r\n"
				+ "JOIN HOCSINH ON CT_BANGDIEMMON_HS.MaHS = HOCSINH.MaHS\r\n"
				+ "JOIN QUATRINH ON HOCSINH.MaHS = QUATRINH.MaHS AND BANGDIEMMON.MaLop = QUATRINH.MaLop AND BANGDIEMMON.MaHK = QUATRINH.MaHK\r\n"
				+ "JOIN LOP ON QUATRINH.MaLop = LOP.MaLop\r\n"
				+ "GROUP BY HOCSINH.TenHS, QUATRINH.diemtbhk\r\n"
				+ "HAVING QUATRINH.DiemTBHK < 5;";
		if (phanLoai.equalsIgnoreCase("xuatSac")) {
			try (Connection connection = datasource.getConnection();
					Statement stmt = connection.createStatement();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EXCELLENT);){
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					PointAllSubject diem = new PointAllSubject(rs.getString(1),rs.getFloat(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8),rs.getFloat(9),rs.getFloat(10),rs.getFloat(11),rs.getFloat(12),rs.getString(13));
					listTypeStudent.add(diem);
				}
				preparedStatement.close();
				rs.close();
				connection.close();
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (phanLoai.equalsIgnoreCase("gioi")) {
			try (Connection connection = datasource.getConnection();
					Statement stmt = connection.createStatement();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GOOD);){
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					PointAllSubject diem = new PointAllSubject(rs.getString(1),rs.getFloat(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8),rs.getFloat(9),rs.getFloat(10),rs.getFloat(11),rs.getFloat(12),rs.getString(13));
					listTypeStudent.add(diem);
				}
				preparedStatement.close();
				rs.close();
				connection.close();
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (phanLoai.equalsIgnoreCase("kha")) {
			try (Connection connection = datasource.getConnection();
					Statement stmt = connection.createStatement();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ELLs);){
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					PointAllSubject diem = new PointAllSubject(rs.getString(1),rs.getFloat(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8),rs.getFloat(9),rs.getFloat(10),rs.getFloat(11),rs.getFloat(12),rs.getString(13));
					listTypeStudent.add(diem);
				}
				preparedStatement.close();
				rs.close();
				connection.close();
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (phanLoai.equalsIgnoreCase("trungBinh")) {
			try (Connection connection = datasource.getConnection();
					Statement stmt = connection.createStatement();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AVERAGE);){
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					PointAllSubject diem = new PointAllSubject(rs.getString(1),rs.getFloat(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8),rs.getFloat(9),rs.getFloat(10),rs.getFloat(11),rs.getFloat(12),rs.getString(13));
					listTypeStudent.add(diem);
				}
				preparedStatement.close();
				rs.close();
				connection.close();
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (phanLoai.equalsIgnoreCase("yeu")) {
			try (Connection connection = datasource.getConnection();
					Statement stmt = connection.createStatement();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WEAK);){
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					PointAllSubject diem = new PointAllSubject(rs.getString(1),rs.getFloat(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8),rs.getFloat(9),rs.getFloat(10),rs.getFloat(11),rs.getFloat(12),rs.getString(13));
					listTypeStudent.add(diem);
				}
				preparedStatement.close();
				rs.close();
				connection.close();
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listTypeStudent;
	}
	
}
