package TimeTable;

import java.util.List;

public class Timetable {

	private int timetableid;
	private int departmentId;
	private int classId;
	private int daysId;
	private int periodId;
	private int subjectId;
	private int facultyid;
	
	public Timetable(int timetableid, int departmentId, int classId, int daysId, int periodId, int subjectId,
			int facultyid) {
		super();
		this.timetableid = timetableid;
		this.departmentId = departmentId;
		this.classId = classId;
		this.daysId = daysId;
		this.periodId = periodId;
		this.subjectId = subjectId;
		this.facultyid = facultyid;
	}

	public int getTimetableid() {
		return timetableid;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public int getClassId() {
		return classId;
	}

	public int getDaysId() {
		return daysId;
	}

	public int getPeriodId() {
		return periodId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public int getFacultyid() {
		return facultyid;
	}

	@Override
	public String toString() {
		return "Timetable [timetableid=" + timetableid + ", departmentId=" + departmentId + ", classId=" + classId
				+ ", daysId=" + daysId + ", periodId=" + periodId + ", subjectId=" + subjectId + ", facultyid="
				+ facultyid + "]";
	}
	
	
	
}

