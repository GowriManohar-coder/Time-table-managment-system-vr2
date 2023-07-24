package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TimetableCRUD {

	private Connection con;
	Scanner scanner = new Scanner(System.in);

	public void timetable() {
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

	public void timetableInsert() {
		try {
			System.out.print("What is the timetable ID? ");
			int timetableid = scanner.nextInt();

			System.out.print("What is the department ID? ");
			int departmentId = scanner.nextInt();

			System.out.print("What is the class ID? ");
			int classId = scanner.nextInt();

			System.out.print("What is the days ID? ");
			int daysId = scanner.nextInt();

			System.out.print("What is the period ID? ");
			int periodId = scanner.nextInt();

			System.out.print("What is the subject ID? ");
			int subjectId = scanner.nextInt();

			System.out.print("What is the faculty ID? ");
			int facultyid = scanner.nextInt();

			String Query = "INSERT INTO timetable_table (timetableid, departmentId, classId, daysId, periodId, subjectId, facultyid) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(Query);

			ps.setInt(1, timetableid);
			ps.setInt(2, departmentId);
			ps.setInt(3, classId);
			ps.setInt(4, daysId);
			ps.setInt(5, periodId);
			ps.setInt(6, subjectId);
			ps.setInt(7, facultyid);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}
	
	public void timetableByFacultyId() {
		try {
		String query = "select * \r\n"
				+ "from timetable as t\r\n"
				+ "join departments as d on t.departmentid = d.departmentid\r\n"
				+ "join classes as c on t.classesid = c.classesid\r\n"
				+ "join faculty as f on t.facultyid = f.facultyid\r\n"
				+ "join subjects as s on t.subjectid = s.subjectid\r\n"
				+ "join days on t.daysid = days.daysid\r\n"
				+ "join period on t.periodid = period.periodid\r\n"
				+ "where f.facultyid = 1";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int timetableid = rs.getInt("timetableid");
			String departmentname = rs.getString("departmentname");
			String classesname = rs.getString("classesname");
			String daysname = rs.getString("daysname");
			String periodfrom = rs.getString("periodfrom");
			String periodto = rs.getString("periodto");
			String subjectname = rs.getString("subjectname");
			String facultyname = rs.getString("facultyname");
			
			
			
		}
		
		ps.execute();
	} catch (SQLException e) {
		System.out.println("Error while inserting data: " + e.getMessage());
	}
	}
}
