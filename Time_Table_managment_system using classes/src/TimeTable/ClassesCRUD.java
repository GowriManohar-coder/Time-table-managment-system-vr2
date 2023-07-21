package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassesCRUD {
	private Connection con;

	public void ClassesCRUD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver found successful");
			String url = "jdbc:mysql://localhost:3306/employee";
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

	public void ClassesInsert(int ClassesId, String ClassesName, int departmentId) {
		try {
			String query = "INSERT INTO Classes (ClassesId, ClassesName, departmentId) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, ClassesId);
			st.setString(2, ClassesName);
			st.setInt(3, departmentId);
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void Classesdelete(int ClassesId) {
		try {
			String query = "DELETE FROM Classes WHERE ClassesId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, ClassesId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void Classesupdate(String ClassesName,int ClassesId) {
		try {
			String query = "UPDATE Classes SET ClassesName = '?' WHERE ClassesId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, ClassesName);
			st.setInt(2, ClassesId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
	
	public void ClassesSelect() {
		try {
			String query = "select * from Classes";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int ClassesId = rs.getInt("ClassesId");
			    String ClassesName = rs.getString("ClassesName");
			    int departmentId = rs.getInt("departmentId");
			    

			    System.out.println(ClassesId + "  " + ClassesName + "  " + ClassesId);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}
}
