package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DepartmentsCRUD { 
	private Connection con;
	Scanner scanner=new Scanner(System.in);

	public DepartmentsCRUD(){
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
	public void departmentsInsert()
	{
		try
		{
			
			 System.out.print("Enter College ID: ");
		        int collegeId = scanner.nextInt();
		        scanner.nextLine(); 

		        System.out.print("Enter Department ID: ");
		        int departmentId = scanner.nextInt();
		        scanner.nextLine(); 

		        System.out.print("Enter Department Name: ");
		        String departmentName = scanner.nextLine();

		        System.out.print("Enter Department Subject: ");
		        String departmentSubject = scanner.nextLine();

		        System.out.print("Enter Department Classes: ");
		        String departmentClasses = scanner.nextLine();

		        System.out.print("Enter Department Faculty: ");
		        String departmentFaculty = scanner.nextLine();

			String query = "INSERT INTO departments (collegeId,departmentId, departmentName, departmentSubject,departmentClasses,departmentFaculty) VALUES (?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,collegeId);
			st.setInt(2, departmentId);
			st.setString(3, departmentName);
			st.setString(4, departmentSubject);
			st.setString(5, departmentClasses);
			st.setString(6, departmentFaculty);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
		}
	public void departmentsdelete()
	{
		try {
			 System.out.print("Enter Department ID: ");
		        int departmentId = scanner.nextInt();
		        scanner.nextLine();
		
			String query = "DELETE FROM departments WHERE departmentId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, departmentId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
	public void departmentsupdate() {
		try {
			   System.out.print("Enter Department ID: ");
		        int departmentId = scanner.nextInt();
		        scanner.nextLine(); // Consume the newline character

		        System.out.print("Enter Department Name: ");
		        String departmentName = scanner.nextLine();
			String query = "UPDATE departments SET departmentName = '?' WHERE departmentId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, departmentName);
			st.setInt(2, departmentId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while update data: " + e.getMessage());
		}
	}
	public void departmentsSelect() {
		try {
			String query = "select * from departments";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int collegeId = rs.getInt("collegeId");
			    int departmentId = rs.getInt("departmentId");
			    String departmentName = rs.getString("departmentName");
			    String departmentSubject = rs.getString("departmentSubject");
			    String departmentClasses = rs.getString("departmentClasses");
			    String departmentfaculty = rs.getString("departmentfaculty");
			    

			    System.out.println(collegeId + "  " + departmentId + "  " + departmentName + "  " + departmentSubject + " "+ departmentClasses + " "  + departmentfaculty);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}
}
