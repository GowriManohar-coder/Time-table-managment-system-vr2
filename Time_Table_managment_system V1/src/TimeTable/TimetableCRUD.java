package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TimetableCRUD {

	Scanner scanner = new Scanner(System.in);

	public void timetableInsert(Connection con) {
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

	public void timetableByFacultyId(Connection con) {
		try {
			System.out.println("Enter the Faculty Id");
			int facultyId = scanner.nextInt();

			String query = "SELECT * FROM timetable AS t " + "JOIN departments AS d ON t.departmentid = d.departmentid "
					+ "JOIN classes AS c ON t.classesid = c.classesid "
					+ "JOIN faculty AS f ON t.facultyid = f.facultyid "
					+ "JOIN subjects AS s ON t.subjectid = s.subjectid " + "JOIN days ON t.daysid = days.daysid "
					+ "JOIN period ON t.periodid = period.periodid " + "WHERE f.facultyid = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, facultyId);
			ResultSet rs = ps.executeQuery();
			System.out.printf("%-15s %-20s %-15s %-15s %-15s %-15s %-20s %-20s%n",
		            "Timetable ID", "Department Name", "Classes Name", "Days Name",
		            "Period From", "Period To", "Subject Name", "Faculty Name");
			while (rs.next()) {
				int timetableid = rs.getInt("timetableid");
				String departmentname = rs.getString("departmentname");
				String classesname = rs.getString("classesname");
				String daysname = rs.getString("daysname");
				String periodfrom = rs.getString("periodfrom");
				String periodto = rs.getString("periodto");
				String subjectname = rs.getString("subjectname");
				String facultyname = rs.getString("facultyname");
				
				System.out.printf("%-15d %-20s %-15s %-15s %-15s %-15s %-20s %-20s%n", timetableid, departmentname,
						classesname, daysname, periodfrom, periodto, subjectname, facultyname);

			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}

	public void timetableByClassesid(Connection con) {
		try {
			System.out.println("Enter the Classes Id");
			int classesId = scanner.nextInt();

			String query = "SELECT * FROM timetable AS t " + "JOIN departments AS d ON t.departmentid = d.departmentid "
					+ "JOIN classes AS c ON t.classesid = c.classesid "
					+ "JOIN faculty AS f ON t.facultyid = f.facultyid "
					+ "JOIN subjects AS s ON t.subjectid = s.subjectid " + "JOIN days ON t.daysid = days.daysid "
					+ "JOIN period ON t.periodid = period.periodid " + "WHERE c.classesid = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, classesId);
			ResultSet rs = ps.executeQuery();
			System.out.printf("%-15s %-20s %-15s %-15s %-15s %-15s %-20s %-20s%n",
		            "Timetable ID", "Department Name", "Classes Name", "Days Name",
		            "Period From", "Period To", "Subject Name", "Faculty Name");
			while (rs.next()) {
				int timetableid = rs.getInt("timetableid");
				String departmentname = rs.getString("departmentname");
				String classesname = rs.getString("classesname");
				String daysname = rs.getString("daysname");
				String periodfrom = rs.getString("periodfrom");
				String periodto = rs.getString("periodto");
				String subjectname = rs.getString("subjectname");
				String facultyname = rs.getString("facultyname");
				
				System.out.printf("%-15d %-20s %-15s %-15s %-15s %-15s %-20s %-20s%n", timetableid, departmentname,
						classesname, daysname, periodfrom, periodto, subjectname, facultyname);

			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}
}
