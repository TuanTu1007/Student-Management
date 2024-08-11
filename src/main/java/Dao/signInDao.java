package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import Model.signIn;

public class signInDao {
	private DataSource datasource;
	
	public signInDao(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public signIn Login(String username, String pass) throws SQLException, ClassNotFoundException{
		
		String sql = "select * from signin where username = ? and pass = ?";
		try (Connection connection = datasource.getConnection();
	         PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, username);
			statement.setString(2, pass);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return new signIn(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (Exception e) {
		}
		return null;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
