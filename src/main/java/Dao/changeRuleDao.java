package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Model.ChangeRule;
import Model.Mon;

public class changeRuleDao {

	private DataSource datasource;

	public changeRuleDao(DataSource datasource) {
		this.datasource = datasource;
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		if (conn != null)
			conn.close();
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();
	}

	public ChangeRule renderThamSo() throws ClassNotFoundException {
		ChangeRule c = null;
		try (Connection connection = datasource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from thamso")) {
			if (rs.next()) {
				int tuoiHSToiDa = rs.getInt("TuoiHSToiDa");
				int tuoiHSToiThieu = rs.getInt("TuoiHSToiThieu");
				int soLuongHSToiDa = rs.getInt("SoLuongHSToiDa");
				int diemToiDa = rs.getInt("DiemToiDa");
				int diemToiThieu = rs.getInt("DiemToiThieu");
				int diemDat = rs.getInt("DiemDat");
				c = new ChangeRule(tuoiHSToiDa, tuoiHSToiThieu, soLuongHSToiDa, diemToiDa, diemToiThieu, diemDat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public boolean insertChangeRule(String nameRule, int value) throws ClassNotFoundException {
		String addColumnQuery = "ALTER TABLE THAMSO ADD " + nameRule + " int";
        String updateRuleQuery = "UPDATE THAMSO SET " + nameRule + " = ?";
		boolean isvalid = false;
		try (Connection connection = datasource.getConnection();
				Statement stmt = connection.createStatement();
				 PreparedStatement alterStmt = connection.prepareStatement(addColumnQuery);
				PreparedStatement updateStmt = connection.prepareStatement(updateRuleQuery)) {
			alterStmt.executeUpdate();
			updateStmt.setInt(1, value);
			int rowAffected = updateStmt.executeUpdate();
			if (rowAffected > 0) {
				isvalid = true;
			} else {
				isvalid = false;
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isvalid;
	}

	public boolean updateTuoiToiThieuToiDa(int tuoiThieu, int tuoiDa) throws SQLException {
		String UPDATE_RULE = "UPDATE THAMSO SET TuoiHSToiThieu = ?, TuoiHSToiDa = ?";
		boolean isvalid = false;
		try (Connection connection = datasource.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_RULE)) {
			statement.setInt(1, tuoiThieu);
			statement.setInt(2, tuoiDa);
			int rowAffected = statement.executeUpdate();
			if (rowAffected > 0) {
				isvalid = true;
			} else {
				isvalid = false;
			}
		}
		return isvalid;
	}

	public boolean updateDiem(int diemToiThieu, int diemToiDa) throws SQLException {
		String UPDATE_RULE = "UPDATE THAMSO SET DiemToiDa = ?, DiemToiThieu = ?";
		boolean isvalid = false;
		try (Connection connection = datasource.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_RULE)) {
			statement.setInt(1, diemToiDa);
			statement.setInt(2, diemToiThieu);
			int rowAffected = statement.executeUpdate();
			if (rowAffected > 0) {
				isvalid = true;
			} else {
				isvalid = false;
			}
		}
		return isvalid;
	}

	public boolean updateSiSoToiDa(int siSoToiDa) throws SQLException {
		String UPDATE_RULE = "UPDATE THAMSO SET SoLuongHSToiDa = ?";
		boolean isvalid = false;
		try (Connection connection = datasource.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_RULE)) {
			statement.setInt(1, siSoToiDa);
			int rowAffected = statement.executeUpdate();
			if (rowAffected > 0) {
				isvalid = true;
			} else {
				isvalid = false;
			}
		}
		return isvalid;
	}

	public boolean updateDiemDat(int diemDat) throws SQLException {
		String UPDATE_RULE = "UPDATE THAMSO SET DiemDat = ? ";
		boolean isvalid = false;
		try (Connection connection = datasource.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_RULE)) {
			statement.setInt(1, diemDat);
			int rowAffected = statement.executeUpdate();

			try (Statement callStatement = connection.createStatement()) {
				String[] calls = {
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L1', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L1', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L1', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L1', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L1', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L1', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L1', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L1', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L1', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L1', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L2', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L2', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L2', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L2', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L2', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L2', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L2', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L2', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L2', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L2', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L3', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L3', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L3', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L3', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L3', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L3', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L3', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L3', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L3', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L3', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L4', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L4', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L4', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L4', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L4', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L4', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L4', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L4', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L4', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L4', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L5', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L5', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L5', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L5', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L5', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L5', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L5', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L5', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L5', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L5', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L6', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L6', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L6', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L6', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L6', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L6', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L6', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L6', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L6', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L6', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L7', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L7', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L7', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L7', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L7', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L7', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L7', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L7', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L7', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L7', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L7', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L7', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L7', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L7', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L7', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L7', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L7', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L7', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L7', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L7', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M1', 'L7', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M2', 'L7', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M3', 'L7', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M4', 'L7', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M5', 'L7', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M6', 'L7', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M7', 'L7', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M8', 'L7', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M9', 'L7', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK1M10', 'L7', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L1', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L1', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L1', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L1', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L1', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L1', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L1', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L1', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L1', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L1', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L2', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L2', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L2', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L2', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L2', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L2', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L2', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L2', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L2', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L2', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L3', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L3', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L3', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L3', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L3', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L3', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L3', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L3', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L3', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L3', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L4', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L4', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L4', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L4', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L4', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L4', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L4', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L4', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L4', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L4', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L5', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L5', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L5', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L5', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L5', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L5', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L5', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L5', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L5', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L5', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L6', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L6', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L6', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L6', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L6', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L6', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L6', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L6', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L6', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L6', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L7', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L7', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L7', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L7', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L7', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L7', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L7', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L7', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L7', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L7', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L7', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L7', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L7', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L7', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L7', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L7', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L7', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L7', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L7', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L7', 'MH10', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M1', 'L7', 'MH1', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M2', 'L7', 'MH2', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M3', 'L7', 'MH3', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M4', 'L7', 'MH4', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M5', 'L7', 'MH5', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M6', 'L7', 'MH6', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M7', 'L7', 'MH7', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M8', 'L7', 'MH8', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M9', 'L7', 'MH9', 'HK1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSubject('BCTKHK2M10', 'L7', 'MH10', 'HK1', @SLDat, @TiLe);",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L1', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L2', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L3', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L4', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L5', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L6', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L7', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L8', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK1', 'L9', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L1', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L2', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L3', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L4', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L5', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L6', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L7', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L8', 'NH1', @SLDat, @TiLe);\r\n",
						"CALL CalculatePassRateAndRatioSemester('HK2', 'L9', 'NH1', @SLDat, @TiLe);\r\n"};
				for (String call : calls) {
					callStatement.execute(call);
				}
			}
			if (rowAffected > 0) {
				isvalid = true;
			} else {
				isvalid = false;
			}
		}
		return isvalid;
	}

}
