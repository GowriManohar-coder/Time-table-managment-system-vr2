package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SubjectsCRUD {

	Scanner scanner = new Scanner(System.in);

	public void subjectInsert(Connection con) {
		try {
			System.out.print("Enter Subject ID: ");
			int subjectId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Subject Name: ");
			String subjectName = scanner.nextLine();
			System.out.print("Enter Class ID: ");
			int classesId = scanner.nextInt();
			String query = "INSERT INTO subject (subjectId, subjectName, classesId) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, subjectId);
			st.setString(2, subjectName);
			st.setInt(4, classesId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void subjectdelete(Connection con) {
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

	public void subjectupdate(Connection con) {
		try {
			System.out.print("Enter Subject ID: ");
			int subjectId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Subject Name: ");
			String subjectName = scanner.nextLine();
			String query = "UPDATE subject SET subjectName = ? WHERE subjectId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, subjectName);
			st.setInt(2, subjectId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void subjectSelect(Connection con) {
		try {
			String query = "select * from subject";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int subjectId = rs.getInt("subjectId");
				String subjectName = rs.getString("subjectName");
				int facultyId = rs.getInt("facultyId");
				int classesId = rs.getInt("classesId");

				System.out.println(subjectId + "  " + subjectName + "  " + classesId);
			}
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
}
