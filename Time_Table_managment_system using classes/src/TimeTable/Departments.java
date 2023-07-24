package TimeTable;

import java.util.List;

public class Departments {
	private int collegeId;
	private int departmentId;
	private String departmentName;
	private List<Subjects> departmentSubject;
	private List<Class> departmentClasses;
	private List<Faculty> departmentFaculty;
	
	public Departments(int collegeId, int departmentId, String departmentName, List<Subjects> departmentSubject,
			List<Class> departmentClasses, List<Faculty> departmentFaculty) {
		super();
		this.collegeId = collegeId;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentSubject = departmentSubject;
		this.departmentClasses = departmentClasses;
		this.departmentFaculty = departmentFaculty;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public List<Subjects> getDepartmentSubject() {
		return departmentSubject;
	}

	public List<Class> getDepartmentClasses() {
		return departmentClasses;
	}

	public List<Faculty> getDepartmentFaculty() {
		return departmentFaculty;
	}

	@Override
	public String toString() {
		return "Departments [collegeId=" + collegeId + ", departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", departmentSubject=" + departmentSubject + ", departmentClasses="
				+ departmentClasses + ", departmentFaculty=" + departmentFaculty + "]";
	}
	
	
}
