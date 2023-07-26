package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ClassesCRUD {
	 Scanner scanner = new Scanner(System.in);
	public void ClassesInsert(Connection con) {
		try {
			  System.out.print("Enter Classes ID: ");
		        int classesId = scanner.nextInt();
		        scanner.nextLine(); 
		        System.out.print("Enter Classes Name: ");
		        String classesName = scanner.nextLine();
		        System.out.print("Enter Department ID: ");
		        int departmentId = scanner.nextInt();
			String query = "INSERT INTO Classes (classesId, classesName, departmentId) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, classesId);
			st.setString(2, classesName);
			st.setInt(3, departmentId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void Classesdelete(Connection con) {
		try {
			  System.out.print("Enter Classes ID: ");
		        int classesId = scanner.nextInt();
		        scanner.nextLine();
			String query = "DELETE FROM Classes WHERE classesId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, classesId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void Classesupdate(Connection con) {
		try {
			 System.out.print("Enter classes Name: ");
		        String classesName = scanner.nextLine();
		        scanner.nextLine();
			  System.out.print("Enter Classes ID: ");
		        int classesId = scanner.nextInt();
		      
			String query = "UPDATE Classes SET classesName = '?' WHERE classesId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, classesName);
			st.setInt(2, classesId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
	
	public void ClassesSelect(Connection con) {
		try {
			String query = "select * from Classes";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int classesId = rs.getInt("classesId");
			    String classesName = rs.getString("classesName");
			    int departmentId = rs.getInt("departmentId");
			    System.out.println(classesId + "  " + classesName + "  " + departmentId);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}
}
