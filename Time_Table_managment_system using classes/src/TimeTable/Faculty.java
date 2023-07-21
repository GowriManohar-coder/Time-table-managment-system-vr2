package TimeTable;

import java.util.List;

public class Faculty {
	
	private int facultyId;
	private String facultyName;
	private List<Subject> subjectId;
	private int departmentId;
	private List<Class> classesId;
	
	public Faculty(int facultyId, String facultyName, List<Subject> subjectId, int departmentId,
			List<Class> classesId) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.subjectId = subjectId;
		this.departmentId = departmentId;
		this.classesId = classesId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public List<Subject> getSubjectId() {
		return subjectId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public List<Class> getClassesId() {
		return classesId;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", subjectId=" + subjectId
				+ ", departmentId=" + departmentId + ", classesId=" + classesId + "]";
	}
	
	
	
	
}
