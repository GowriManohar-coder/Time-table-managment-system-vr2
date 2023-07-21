package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CollegeCRUD {
	private Connection con;

	public void CollegeCRUD() {
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

	public void collegeInsert(int collegeId, String collegeName, String collegeDepartments) {
		try {
			String query = "INSERT INTO college (collegeId, collegeName,collegeDepartments) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, collegeId);
			st.setString(2, collegeName);
			st.setString(3, collegeDepartments);
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void collegedelete(int collegeId) {
		try {
			String query = "DELETE FROM college WHERE collegeId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, collegeId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
	
	public void collegeupdate(String collegeName,int collegeId) {
		try {
			String query = "UPDATE college SET collegeName = '?' WHERE collegeId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, collegeName);
			st.setInt(2, collegeId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
	
	public void collegeSelect() {
		try {
			String query = "select * from college";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int collegeId = rs.getInt("collegeId");
			    String collegeName = rs.getString("collegeName");
			    String collegeDepartments = rs.getString("collegeDepartments");
			    

			    System.out.println(collegeId + "  " + collegeName + "  " + collegeDepartments );
			}
		} catch (SQLException e) {
			System.out.println("Error while Reading data: " + e.getMessage());
		}
	}

}
