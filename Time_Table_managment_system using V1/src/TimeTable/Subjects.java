package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;

public class Subjects {
	
	private int subjectId;
	private String subjectName;
	private int classesId;
	
	public Subjects(int subjectId, String subjectName, int classesId) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.classesId = classesId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public int getClassesId() {
		return classesId;
	}

	@Override
	public String toString() {
		return "Subjects [subjectId=" + subjectId + ", subjectName=" + subjectName + ", classesId=" + classesId + "]";
	}
	
	
}
