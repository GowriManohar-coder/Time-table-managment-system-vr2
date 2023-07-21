package TimeTable;

import java.time.LocalDate;
import java.util.List;

public class College {
	
	private int collegeId;
	private String collegeName;
	private List<Departments> collegeDepartments;
	
	public College(int collegeId, String collegeName, List<Departments> collegeDepartments) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeDepartments = collegeDepartments;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public List<Departments> getCollegeDepartments() {
		return collegeDepartments;
	}

	
}
