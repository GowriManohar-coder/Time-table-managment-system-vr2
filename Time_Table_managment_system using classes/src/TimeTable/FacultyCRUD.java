package TimeTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FacultyCRUD {
	private Connection con;

	public void facultyCRUD() {
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

	public void facultyInsert(int facultyId, String facultyName, int departmentId, int subjectId, int classId) {
		try {
			facultyCRUD();
			String query = "INSERT INTO faculty (facultyId, facultyName, departmentId, subjectId,   classId) VALUES (?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, facultyId);
			st.setString(2, facultyName);
			st.setInt(3, departmentId);
			st.setInt(4, subjectId);
			st.setInt(5, classId);
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void facultydelete(int facultyId) {
		try {
			facultyCRUD();
			String query = "DELETE FROM subjects WHERE subjectId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, facultyId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void facultyupdate(String facultyName,int facultyId) {
		try {
			facultyCRUD();
			String query = "UPDATE subjects SET facultyName = '?' WHERE facultyId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, facultyName);
			st.setInt(2, facultyId);
		} catch (SQLException e) {
			System.out.println("Error while updating data: " + e.getMessage());
		}
	}
	
	public void facultySelect() {
		try {
			facultyCRUD();
			String query = "select * from faculty";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int facultyId = rs.getInt("facultyId");
			    String facultyName = rs.getString("facultyName");
			    int subjectId = rs.getInt("subjectId");
			    int departmentId = rs.getInt("departmentId");
			    int classId = rs.getInt("classId");

			    System.out.println(facultyId + " " + facultyName +" "+ subjectId +" " + departmentId + " " + classId);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}

}

