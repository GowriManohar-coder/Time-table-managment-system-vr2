package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;

public class Subject {
	
	private int subjectId;
	private String subjectName;
	private int facultyId;
	private int classId;
	public Subject(int subjectId, String subjectName, int facultyId, int classId) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.facultyId = facultyId;
		this.classId = classId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public int getClassId() {
		return classId;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", facultyId=" + facultyId + ", classId=" + classId + "]";
	}
	
	

}
