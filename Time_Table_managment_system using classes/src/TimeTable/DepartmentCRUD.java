package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentCRUD { 
	private Connection con;

	public void departmentCrud(){
    try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sravika", "root", "root");
    System.out.println("connected to data base");
    con.close();
	} catch (ClassNotFoundException e) {
		System.out.println("unable to find the driver");
	} catch (SQLException e) {
		System.out.println("unable to connect with database");
	}

}
	public void departmentsCreate(int collegeId,int departmentId, String departmentName,String departmentSubject,String departmentClasses,String departmentFaculty)
	{
		try{
			String query = "INSERT INTO departments (collegeId,departmentId, departmentName, departmentSubject,departmentClasses,departmentFaculty) VALUES (?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,collegeId);
			st.setInt(2, departmentId);
			st.setString(3, departmentName);
			st.setString(4, departmentSubject);
			st.setString(5, departmentClasses);
			st.setString(5, departmentFaculty);
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
		}
	public void departmentsDelete(int departmentId)
	{
		try {
		
			String query = "DELETE FROM departments WHERE departmentId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, departmentId);
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
	public void departmentsUpdate(String departmentName,int departmentId) {
		try {
			String query = "UPDATE departments SET departmentName = '?' WHERE departmentId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, departmentName);
			st.setInt(2, departmentId);
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
			    String  departmentfaculty = rs.getString("departmentfaculty");
			    

			    System.out.println(collegeId + "  " + departmentId + "  " + departmentName + "  " + departmentSubject + " "+ departmentClasses + " "  + departmentfaculty);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}
}
