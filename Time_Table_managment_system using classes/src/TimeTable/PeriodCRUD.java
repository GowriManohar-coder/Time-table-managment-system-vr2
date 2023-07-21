package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PeriodCRUD {

	private Connection con;
	Scanner scanner = new Scanner(System.in);

	public  PeriodCRUD() {
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

	public void periodInsert() {
		try {
			System.out.print("Enter Period ID: ");
			int periodId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Period From (e.g., 9-Pm): ");
			String periodFrom = scanner.nextLine();
			System.out.print("Enter Period To (e.g., 9-Pm): ");
			String periodTo = scanner.nextLine();
			System.out.print("Enter classes ID: ");
			int classesId = scanner.nextInt();
			System.out.print("Enter faculty ID: ");
			int facultyId = scanner.nextInt();
			String query = "INSERT INTO period (periodId, periodFrom, periodTo, classesId, facultyId) VALUES (?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, periodId);
			st.setString(2, periodFrom);
			st.setString(3, periodTo);
			st.setInt(4, classesId);
			st.setInt(5, facultyId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void perioddelete() {
		try {
			System.out.print("Enter Period ID: ");
			int periodId = scanner.nextInt();
			String query = "DELETE FROM period WHERE periodId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, periodId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void periodupdate() {
		try {
			System.out.print("Enter Period ID: ");
			int periodId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Period From (e.g., 9-Pm): ");
			String periodFrom = scanner.nextLine();
			String query = "UPDATE period SET periodFrom = '?', periodTo = '?' WHERE periodId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, periodFrom);
			st.setInt(2, periodId);
			st.execute();
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
