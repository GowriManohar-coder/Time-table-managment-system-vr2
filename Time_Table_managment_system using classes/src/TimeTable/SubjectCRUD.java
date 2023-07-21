package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SubjectCRUD {
	private Connection con;
	Scanner scanner = new Scanner(System.in);

	public  SubjectCRUD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver found successful");
			String url = "jdbc:mysql://localhost:3306/manohar";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connected with database successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("unable to find the driver");
		} catch (SQLException e) {
			System.out.println("unable to connect with database");
		}

	}

	public void subjectInsert() {
		try {
			System.out.print("Enter Subject ID: ");
			int subjectId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Subject Name: ");
			String subjectName = scanner.nextLine();
			System.out.print("Enter Faculty ID: ");
			int facultyId = scanner.nextInt();
			scanner.nextLine(); 
			System.out.print("Enter Class ID: ");
			int classId = scanner.nextInt();
			String query = "INSERT INTO subject (subjectId, subjectName, facultyId, classId) VALUES (?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, subjectId);
			st.setString(2, subjectName);
			st.setInt(3, facultyId);
			st.setInt(4, classId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void subjectdelete() {
		try {
			System.out.print("Enter Subject ID: ");
			int subjectId = scanner.nextInt();
			String query = "DELETE FROM subject WHERE subjectId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, subjectId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void subjectupdate() {
		try {
			System.out.print("Enter Subject ID: ");
			int subjectId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Subject Name: ");
			String subjectName = scanner.nextLine();
			String query = "UPDATE subject SET subjectName = '?' WHERE subjectId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, subjectName);
			st.setInt(2, subjectId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void subjectSelect() {
		try {
			String query = "select * from subject";
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
