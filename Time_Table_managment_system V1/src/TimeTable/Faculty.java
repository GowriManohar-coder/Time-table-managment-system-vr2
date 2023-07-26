package TimeTable;

import java.util.List;

public class Faculty {
	
	private int facultyId;
	private String facultyName;
	private int departmentId;
	
	public Faculty(int facultyId, String facultyName, int departmentId) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.departmentId = departmentId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", departmentId=" + departmentId
				+ "]";
	}
	
	
}