package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.Year;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import Model.HocSinh;
import Model.Lop;
import Model.Mon;
import Model.TraCuuHocSinh;
import Model.signIn;

public class InfoStudentsDao {
	
	private DataSource datasource;
	
	public InfoStudentsDao(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<HocSinh> selectAllStudent() throws ClassNotFoundException {
		List<HocSinh> DSHS = new ArrayList<>();
		try	(Connection connection = datasource.getConnection();
			Statement statement = connection.createStatement();	
			ResultSet rs = statement.executeQuery("select * from HocSinh")) {
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
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return DSHS;
	}
	
	public HocSinh selectOneStudent(String maHS) throws ClassNotFoundException {
		String sql = "select * from hocsinh where mahs = ?;";
		try (Connection connection = datasource.getConnection();
		         PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setString(1, maHS);
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					return new HocSinh(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4).substring(0,10),rs.getString(5),rs.getString(6));
				}
			} catch (Exception e) {
			}
		return null;
	}
	
	public List<TraCuuHocSinh> selectStudent (String name, String nameClass) throws ClassNotFoundException, SQLException {
		List<TraCuuHocSinh> tchsList = new ArrayList<>();
		String SELECT_STUDENT_BY_NAME = "SELECT HocSinh.TenHS, Lop.TenLop, qthk1.DiemTBHK AS DiemTBHK1, qthk2.DiemTBHK AS DiemTBHK2\r\n"
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
	
	public boolean insertListStudents(List<HocSinh> students) throws ClassNotFoundException {
        String querySelectId = "SELECT MaHS FROM HocSinh ORDER BY LENGTH(MaHS), MaHS";
        String INSERT_STUDENT = "INSERT INTO HocSinh VALUES (?,?,?,?,?,?)";
        boolean isSuccess = false;
        Connection connection = null;
        Statement stmt = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            connection = datasource.getConnection();
            connection.setAutoCommit(false); 
            stmt = connection.createStatement();
            statement = connection.prepareStatement(INSERT_STUDENT);
            rs = stmt.executeQuery(querySelectId);

            String currentStudentId = "";
            String nextStudentId = "";
            String prefixStudentId = "HS";
            int max = 1;
            int traceUnindexed = 1;
            int fillUnindexed = 0;

            while (rs.next()) {
                currentStudentId = rs.getString(1);

                if (!currentStudentId.isEmpty()) {
                    if (traceUnindexed != Integer.valueOf(currentStudentId.substring(2))) {
                        fillUnindexed = 1;
                        break;
                    } else {
                        traceUnindexed++;
                    }
                    if (Integer.parseInt(currentStudentId.substring(2)) > max) {
                        max = Integer.parseInt(currentStudentId.substring(2));
                    }
                }
            }

            for (HocSinh hs : students) {
                if (!currentStudentId.isEmpty()) {
                    if (fillUnindexed == 1) {
                        nextStudentId = prefixStudentId + Integer.toString(traceUnindexed);
                        fillUnindexed = 0; 
                    } else {
                        nextStudentId = prefixStudentId + Integer.toString(max + 1);
                    }
                } else {
                    nextStudentId = prefixStudentId + "1";
                }

                statement.setString(1, nextStudentId);
                statement.setString(2, hs.getTenHS());
                statement.setString(3, hs.getGioiTinh());
                statement.setString(4, hs.getNamSinh());
                statement.setString(5, hs.getDiaChi());
                statement.setString(6, hs.getEmail());

                statement.addBatch(); 
                max++; 
            }

            int[] rowsAffected = statement.executeBatch(); 

            isSuccess = Arrays.stream(rowsAffected).allMatch(row -> row > 0);

            connection.commit(); 
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback(); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return isSuccess;
    }

//	public boolean insertStudent(HocSinh hs) throws ClassNotFoundException {
//		String querySelectId = "SELECT MaHS FROM HocSinh order by length(MaHS), MaHS";
//		String INSERT_STUDENT = "INSERT INTO HocSinh VALUES (?,?,?,?,?,?)";
//		boolean isvalid = false;
//		try (Connection connection = datasource.getConnection();
//				Statement stmt = connection.createStatement();
//				PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT);
//				ResultSet rs = stmt.executeQuery(querySelectId)) {
//			String currentStudentId = "";
//			String nextStudentId = "";
//			String prefixStudentId = "HS";
//			int max = 1;
//			int traceUnindexed = 1;
//			int fillUnindexed = 0;
//			while (rs.next()) {
//				currentStudentId = rs.getString(1);
//				
//				if(currentStudentId != "") {
//					if(traceUnindexed != Integer.valueOf(currentStudentId.substring(2))) {
//						fillUnindexed = 1;
//						break;
//					}
//					else {
//						traceUnindexed++;
//					}
//					if(Integer.parseInt(currentStudentId.substring(2)) > max){
//						max = Integer.parseInt(currentStudentId.substring(2));
//					}
//				}
//			}
//			if(currentStudentId != "") {
//				if(fillUnindexed == 1) {
//					nextStudentId = prefixStudentId + Integer.toString(traceUnindexed);
//				}
//				else {
//					nextStudentId = prefixStudentId + Integer.toString(max + 1);
//				}
//			} else
//				nextStudentId = prefixStudentId + "1";	
//				
//			statement.setString(1, nextStudentId);
//			statement.setString(2, hs.getTenHS());
//			statement.setString(3, hs.getGioiTinh());
//			statement.setString(4, hs.getNamSinh());
//			statement.setString(5, hs.getDiaChi());
//			statement.setString(6, hs.getEmail());
//				
//			int rowAffected = statement.executeUpdate();
//			if (rowAffected > 0) {
//				isvalid = true;
//			} else {
//				isvalid = false;
//			}
//			statement.close();
//			rs.close();
//			stmt.close();
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return isvalid;
//	}
	
	public boolean updateInfoStudent(HocSinh hs, String nameStudent, String address, String email, String bd) throws ClassNotFoundException {
		String SELECT_STUDENT = "select * from hocsinh";
		String UPDATE_STUDENT = "update hocsinh set NamSinh = ?, DiaChi = ?, Email = ? where MaHS = ?";
		boolean isvalid = false;
		try (Connection connection = datasource.getConnection();
				Statement stmt = connection.createStatement();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT);
				ResultSet rs = stmt.executeQuery(SELECT_STUDENT))
		{
			String currentNameStudent = "";
			String currentStudentId = "";
			while(rs.next()) {
				currentNameStudent = rs.getString(2);
				if (currentNameStudent.equalsIgnoreCase(nameStudent.trim())) {
					currentStudentId = rs.getString(1);
				}
			}
			statement.setString(1, hs.getNamSinh());	
			statement.setString(2, hs.getDiaChi());
			statement.setString(3, hs.getEmail());	
			statement.setString(4, currentStudentId);	
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				isvalid = true;
			} else {
				isvalid = false;
			}

			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isvalid;
	}
	
	public boolean checkEmail(HocSinh hs) throws ClassNotFoundException, SQLException {
		String querySelectEmail = "SELECT COUNT(*) FROM HocSinh WHERE Email = ?";
	    boolean isvalid = false;
	    try (Connection connection = datasource.getConnection();
	         PreparedStatement emailStatement = connection.prepareStatement(querySelectEmail)) {

	        emailStatement.setString(1, hs.getEmail());
	        ResultSet emailResultSet = emailStatement.executeQuery();
	        emailResultSet.next();
	        int emailCount = emailResultSet.getInt(1);
	        emailResultSet.close();

	        if (emailCount > 0) {
	        	isvalid = false;
	        }
	        else {
	        	isvalid = true;
	        }
	    }
	    System.out.println(isvalid);
		return isvalid;
	}
	
	public boolean checkAge(HocSinh hs) throws ClassNotFoundException {
		String querySelectId = "SELECT TuoiHSToiThieu, TuoiHSToiDa FROM ThamSo";
		boolean isvalid = false;
		try (Connection connection = datasource.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(querySelectId)) {
			int toiThieu = -1;
			int toiDa = -1;
			while (rs.next()) {
				toiThieu = rs.getInt(1);
				toiDa = rs.getInt(2);
			}
			
			int year = Year.now().getValue();
			if (year - Integer.parseInt(hs.getNamSinh().substring(0,4)) >= toiThieu && year - Integer.parseInt(hs.getNamSinh().substring(0,4)) <= toiDa) {
				isvalid = true;
			} else {
				isvalid = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isvalid;
	}
	
	public boolean checkEmailList(List<HocSinh> students) throws ClassNotFoundException, SQLException {
	    String querySelectEmail = "SELECT Email FROM HocSinh WHERE Email IN (";
	    StringBuilder queryBuilder = new StringBuilder(querySelectEmail);

	    for (int i = 0; i < students.size(); i++) {
	        queryBuilder.append("?");
	        if (i < students.size() - 1) {
	            queryBuilder.append(", ");
	        }
	    }
	    queryBuilder.append(")");

	    try (Connection connection = datasource.getConnection();
	         PreparedStatement emailStatement = connection.prepareStatement(queryBuilder.toString())) {

	        for (int i = 0; i < students.size(); i++) {
	            emailStatement.setString(i + 1, students.get(i).getEmail());
	        }

	        ResultSet emailResultSet = emailStatement.executeQuery();

	        Set<String> existingEmails = new HashSet<>();
	        while (emailResultSet.next()) {
	            existingEmails.add(emailResultSet.getString(1));
	        }
	        emailResultSet.close();

	        for (HocSinh hs : students) {
	            if (existingEmails.contains(hs.getEmail())) {
	                return false; // Có email trùng lặp
	            }
	        }
	    }
	    return true; // Không có email trùng lặp
	}
	
	public boolean checkAgeList(List<HocSinh> students) throws ClassNotFoundException {
	    String querySelectId = "SELECT TuoiHSToiThieu, TuoiHSToiDa FROM ThamSo";
	    boolean isvalid = true;

	    try (Connection connection = datasource.getConnection();
	         Statement stmt = connection.createStatement();
	         ResultSet rs = stmt.executeQuery(querySelectId)) {

	        int toiThieu = -1;
	        int toiDa = -1;
	        if (rs.next()) {
	            toiThieu = rs.getInt(1);
	            toiDa = rs.getInt(2);
	        }

	        int currentYear = Year.now().getValue();
	        for (HocSinh hs : students) {
	            int birthYear = Integer.parseInt(hs.getNamSinh().substring(0, 4));
	            int age = currentYear - birthYear;

	            if (age < toiThieu || age > toiDa) {
	                isvalid = false;
	                break;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        isvalid = false;
	    }
	    return isvalid;
	}
}
