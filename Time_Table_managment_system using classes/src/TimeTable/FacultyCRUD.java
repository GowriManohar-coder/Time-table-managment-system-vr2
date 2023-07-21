package TimeTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class FacultyCRUD {
	private Connection con;
	Scanner scanner = new Scanner(System.in);
	public  facultyCRUD() {
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

	public void facultyInsert() {
		try {
			System.out.print("Enter Faculty ID: ");
	        int facultyId = scanner.nextInt();

	        System.out.print("Enter Faculty Name: ");
	        scanner.nextLine(); // Consume the newline left by nextInt()
	        String facultyName = scanner.nextLine();

	        System.out.print("Enter Department ID: ");
	        int departmentId = scanner.nextInt();

	        System.out.print("Enter Subject ID: ");
	        int subjectId = scanner.nextInt();

	        System.out.print("Enter Classes ID: ");
	        int classesId = scanner.nextInt();

			String query = "INSERT INTO faculty (facultyId, facultyName, departmentId, subjectId, classesId) VALUES (?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, facultyId);
			st.setString(2, facultyName);
			st.setInt(3, departmentId);
			st.setInt(4, subjectId);
			st.setInt(5, classesId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void facultydelete() {
		try {
			System.out.print("Enter Faculty ID: ");
	        int facultyId = scanner.nextInt();

			String query = "DELETE FROM faculty WHERE facultyId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, facultyId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void facultyupdate() {
		try {
			System.out.print("Enter Faculty ID: ");
	        int facultyId = scanner.nextInt();

	        System.out.print("Enter Faculty Name: ");
	        scanner.nextLine(); // Consume the newline left by nextInt()
	        String facultyName = scanner.nextLine();

			String query = "UPDATE faculty SET facultyName = '?' WHERE facultyId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, facultyName);
			st.setInt(2, facultyId);
			st.execute();
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
			    int classId = rs.getInt("classesId");

			    System.out.println(facultyId + " " + facultyName +" "+ subjectId +" " + departmentId + " " + classId);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}

}

