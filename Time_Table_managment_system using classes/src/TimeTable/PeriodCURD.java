package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodCURD {
	
	private Connection con;

	public void periodCURD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver found successful");
			String url = "jdbc:mysql://localhost:3306/manohar";
			String username = "root";
			String password = "root";
			Connection con;
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connected with database successfully");
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("unable to find the driver");
		} catch (SQLException e) {
			System.out.println("unable to connect with database");
		}

	}

	public void periodInsert(int periodId, String periodFrom, String periodTo) {
		try {
			String query = "INSERT INTO period (periodId, periodFrom, periodTo) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, periodId);
			st.setString(2, periodFrom);
			st.setString(3, periodTo);
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void perioddelete(int periodId) {
		try {
			String query = "DELETE FROM subjects WHERE periodId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, periodId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void periodupdate(int periodId, String periodFrom) {
		try {
			String query = "UPDATE subjects SET periodFrom = '?' WHERE periodId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, periodFrom);
			st.setInt(2, periodId);
		} catch (SQLException e) {
			System.out.println("Error while updating data: " + e.getMessage());
		}
	}
	
	public void periodSelect() {
		try {
			String query = "select * from period";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int periodId = rs.getInt("periodId");
			    String periodFrom = rs.getString("periodFrom");
			    int periodTo = rs.getInt("periodTo");

			    System.out.println(periodId + "  " + periodFrom + "  " + periodTo);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}

}
