package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.*;

public class Main {
	public void frame() {	
	}
	
	public static void main(String[] args) {
		Connection con = null;
		JFrame jf = new JFrame("Time Table Managment System");
		JButton b = new JButton("click me");
		b.setBounds(200, 400, 100, 30);
		jf.add(b); jf.setLayout(null);
		jf.setSize(500,500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		Scanner scan = new Scanner(System.in);
		CollegeCRUD c = new CollegeCRUD();
		DepartmentsCRUD d = new DepartmentsCRUD();
		ClassesCRUD cl = new ClassesCRUD();
		SubjectsCRUD s = new SubjectsCRUD();
		FacultyCRUD f = new FacultyCRUD();
		PeriodCRUD p = new PeriodCRUD();
		DaysCRUD da = new DaysCRUD();
		TimetableCRUD tt = new TimetableCRUD();
		while(true) {
			System.out.println("=================TIME TABLE MANAGMENT SYSTEM=============");
			System.out.println("\n\tPress 1 for inserting into college table");
			System.out.println("\tPress 2 for inserting into department table");
			System.out.println("\tPress 3 for inserting into classes table");
			System.out.println("\tPress 4 for inserting into subject table");
			System.out.println("\tPress 5 for inserting into faculty table");
			System.out.println("\tPress 6 for inserting into period table");
			System.out.println("\tPress 7 for inserting into days table");
			System.out.println("\n\tPress 8 to delete data from college table");
			System.out.println("\tPress 9 to delete data from department table");
			System.out.println("\tPress 10 to delete data from classes table");
			System.out.println("\tPress 11 to delete data from subject table");
			System.out.println("\tPress 12 to delete data from faculty table");
			System.out.println("\tPress 13 to delete data from period table");
			System.out.println("\tPress 14 to delete data from days table");
			System.out.println("\n\tPress 15 for updating college table");
			System.out.println("\tPress 16 for updating department table");
			System.out.println("\tPress 17 for updating classes table");
			System.out.println("\tPress 18 for updating subject table");
			System.out.println("\tPress 19 for updating faculty table");
			System.out.println("\tPress 20 for updating period table");
			System.out.println("\tPress 21 for updating days table");
			System.out.println("\n\tPress 22 to view college table");
			System.out.println("\tPress 23 to view department table");
			System.out.println("\tPress 24 to view classes table");
			System.out.println("\tPress 25 to view subject table");
			System.out.println("\tPress 26 to view faculty table");
			System.out.println("\tPress 27 to view period table");
			System.out.println("\tPress 28 to view days table");
			System.out.println("\tPress 29 for inserting into TimeTable table");
			System.out.println("\tPress 30 to view Faculty Time Table");
			System.out.println("\tPress 31 to view Class Time Table");
			System.out.println("\n\tPlease Enter your Choice..");
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1 : c.collegeInsert(con); break;
			case 2 : d.departmentsInsert(con);break;
			case 3 : cl .ClassesInsert(con);break;
			case 4 : s.subjectInsert(con); break;
			case 5 : f.facultyInsert(con);break;
			case 6 : p.periodInsert(con); break;
			case 7 : da.daysInsert(con);break;
			case 8 : c.collegedelete(con); break;
			case 9 : d.departmentsdelete(con);break;
			case 10 : cl .Classesdelete(con);break;
			case 11 : s.subjectdelete(con); break;
			case 12 : f.facultydelete(con);break;
			case 13 : p.perioddelete(con); break;
			case 14 : da.daysdelete(con);break;
			case 15 : c.collegeupdate(con); break;
			case 16 : d.departmentsupdate(con);break;
			case 17 : cl .Classesupdate(con);break;
			case 18 : s.subjectupdate(con); break;
			case 19 : f.facultyupdate(con);break;
			case 20 : p.periodupdate(con); break;
			case 21 : da.daysupdate(con);break;
			case 22 : c.collegeSelect(con); break;
			case 23 : d.departmentsSelect(con);break;
			case 24 : cl .ClassesSelect(con);break;
			case 25 : s.subjectSelect(con); break;
			case 26 : f.facultySelect(con);break;
			case 27 : p.periodSelect(con); break;
			case 28 : da.daysSelect(con);break;
			case 29 : tt.timetableInsert(con);;break;
			case 30 : tt.timetableByFacultyId(con);;break;
			case 31 : tt.timetableByClassesid(con);;break;
			case 0: System.exit(choice);
			default : System.out.println("Please choose your option between 0 and 28");
		
			}
		}
	}

}
