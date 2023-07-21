package TimeTable;

public class Subject {
	
	private int subjectId;
	private String subjectName;
	private int departmentId;
	private int facultyId;
	private int classId;
	public Subject(int subjectId, String subjectName, int departmentId, int facultyId, int classId) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.departmentId = departmentId;
		this.facultyId = facultyId;
		this.classId = classId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public int getClassId() {
		return classId;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", departmentId=" + departmentId
				+ ", facultyId=" + facultyId + ", classId=" + classId + "]";
	}
	
	
	
	
	

}
