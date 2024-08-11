package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Model.TraCuuBaoCao;

public class ReportDao {
	private DataSource datasource;
	
	public ReportDao(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<TraCuuBaoCao> selectReport (String reportType, String subject, String semester) throws ClassNotFoundException, SQLException {
		List<TraCuuBaoCao> listReport = new ArrayList<>();
		String SELECT_BCTKHK = "SELECT l.TenLop, l.siSO, bctkhk.SLDat, bctkhk.TiLe"
							+ " FROM BaoCaoTongKetHocKy  bctkhk, LOP l, HocKy hk"
							+ " WHERE hk.TenHK = ? AND bctkhk.MaLop = l.MaLop AND bctkhk.MaHK = hk.MaHK;";
		String SELECT_BCTKM = "SELECT DISTINCT l.TenLop, l.SiSo, ct_bctkm.SLDat, ct_bctkm.TiLe"
							+ " FROM BaoCaoTongKetMon bctkhk, CT_BCTKM ct_bctkm, LOP l, HocKy hk, MON m"
							+ " WHERE ct_bctkm.MaLop = l.MaLop AND bctkhk.MaHK = hk.MaHK AND bctkhk.MaBCTKM = ct_bctkm.MaBCTKM"
							+ " AND bctkhk.MaMH = m.MaMH AND hk.TenHK = ? AND m.TenMH = ?;";
		if(reportType.equalsIgnoreCase("report-semester")) {
			
			try (Connection connection = datasource.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BCTKHK)){
				preparedStatement.setString(1, semester);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					String tenLop= rs.getString(1);
					int siSo = rs.getInt(2);
					int slDat = rs.getInt(3);
					float tile = rs.getFloat(4);
					
					TraCuuBaoCao tcbc = new TraCuuBaoCao(tenLop, siSo, slDat, tile);
					listReport.add(tcbc);
				}
				preparedStatement.close();
				rs.close();
				connection.close();
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (reportType.equalsIgnoreCase("report-subject")) {
			try (Connection connection = datasource.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BCTKM)){
				preparedStatement.setString(1, semester);
				preparedStatement.setString(2, subject);
				ResultSet rs = preparedStatement.executeQuery();
				
				while (rs.next()) {
					String tenLop= rs.getString(1);
					int siSo = rs.getInt(2);
					int slDat = rs.getInt(3);
					float tile = rs.getFloat(4);
					
					TraCuuBaoCao tcbc = new TraCuuBaoCao(tenLop, siSo, slDat, tile);
					listReport.add(tcbc);
				}
				preparedStatement.close();
				rs.close();
				connection.close();
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listReport;
	}
}
