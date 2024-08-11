package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Model.TraCuuHocSinh;

public class searchStudentDao {
	private DataSource datasource;

	public searchStudentDao(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<TraCuuHocSinh> selectStudent (String name, String nameClass) throws ClassNotFoundException, SQLException {
		List<TraCuuHocSinh> tchsList = new ArrayList<>();
		String SELECT_STUDENT_BY_NAME = "SELECT distinct HocSinh.TenHS, Lop.TenLop, qthk1.DiemTBHK AS DiemTBHK1, qthk2.DiemTBHK AS DiemTBHK2\r\n"
				+ "FROM HocSinh\r\n"
				+ "LEFT JOIN QuaTrinh qthk1 ON HocSinh.MaHS = qthk1.MaHS\r\n"
				+ "LEFT JOIN HocKy hk1 ON qthk1.MaHK = hk1.MaHK AND hk1.TenHK = '1'\r\n"
				+ "LEFT JOIN QuaTrinh qthk2 ON HocSinh.MaHS = qthk2.MaHS\r\n"
				+ "LEFT JOIN HocKy hk2 ON qthk2.MaHK = hk2.MaHK AND hk2.TenHK = '2'\r\n"
				+ "LEFT JOIN Lop ON qthk1.MaLop = Lop.MaLop\r\n"
				+ "WHERE HocSinh.TenHS = ? AND Lop.TenLop = ?;";
		try (Connection connection = datasource.getConnection();
				Statement stmt = connection.createStatement();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_NAME)){
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, nameClass);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String namehs = rs.getString(1);
				String lop = rs.getString(2);
				float tbhk1 = rs.getFloat(3);
				float tbhk2 = rs.getFloat(4);
				TraCuuHocSinh tchs = new TraCuuHocSinh(namehs, lop, tbhk1, tbhk2);
				tchsList.add(tchs);
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return tchsList;
	}
}
