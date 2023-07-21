package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DaysCRUD {
	private Connection con;
	Scanner scanner = new Scanner(System.in);
	public void daysCRUD() {
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

	public void daysInsert() {
		try {
			System.out.print("Enter Days ID: ");
	        int daysId = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("Enter Days Name: ");
	        String daysName = scanner.nextLine();
			String query = "INSERT INTO days (daysId, daysName) VALUES (?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, daysId);
			st.setString(2, daysName);
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void daysdelete() {
		try {
			System.out.print("Enter Days ID: ");
	        int daysId = scanner.nextInt();
			String query = "DELETE FROM days WHERE daysId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, daysId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void daysupdate() {
		try {
			System.out.print("Enter Days ID: ");
	        int daysId = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("Enter Days Name: ");
	        String daysName = scanner.nextLine();
			String query = "UPDATE days SET daysName = '?' WHERE daysId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, daysName);
			st.setInt(2, daysId);
		} catch (SQLException e) {
			System.out.println("Error while updating data: " + e.getMessage());
		}
	}
	
	public void daysSelect() {
		try {
			String query = "select * from days";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int daysId = rs.getInt("daysId");
			    String daysName = rs.getString("daysName");

			    System.out.println(daysId + "  " + daysName);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}

}
