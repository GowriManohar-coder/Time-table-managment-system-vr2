package TimeTable;

public class Main {
	
	public static void main(String[] args) {
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
			System.out.println("\n\tPlease Enter your Choice..");
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1 : collegeinsert(); break;
			case 2 : departmentinsert();break;
			case 3 : ();break;
			case 4 : (); break;
			case 5 : ();break;
			case 9 : System.exit(choice);
			default : System.out.println("Please choose your option between 1 and 5");
			}
		}
	}

}
