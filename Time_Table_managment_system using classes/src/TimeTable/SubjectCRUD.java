package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectCRUD {
	private Connection con;

	public void subjectCRUD() {
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

	public void subjectInsert(int subjectId, String subjectName, int facultyId, int classId) {
		try {
			String query = "INSERT INTO subjects (subjectId, subjectName, facultyId, classId) VALUES (?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, subjectId);
			st.setString(2, subjectName);
			st.setInt(3, facultyId);
			st.setInt(4, classId);
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void subjectdelete(int subjectId) {
		try {
			String query = "DELETE FROM subjects WHERE subjectId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, subjectId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void subjectupdate(String subjectName,int subjectId) {
		try {
			String query = "UPDATE subjects SET subjectName = '?' WHERE subjectId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, subjectName);
			st.setInt(2, subjectId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
	
	public void subjectSelect() {
		try {
			String query = "select * from subjects";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int subjectId = rs.getInt("subjectId");
			    String subjectName = rs.getString("subjectName");
			    int facultyId = rs.getInt("facultyId");
			    int classId = rs.getInt("classId");

			    System.out.println(subjectId + "  " + subjectName + "  " + facultyId + "  " + classId);
			}
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
}
