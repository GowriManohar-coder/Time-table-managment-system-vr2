package TimeTable;

public class Period {
	
	private int periodId;
	private String periodFrom;
	private String periodTo;
	private int classesId;
	private int facultyId;
	
	public Period(int periodId, String periodFrom, String periodTo, int classesId, int facultyId) {
		super();
		this.periodId = periodId;
		this.periodFrom = periodFrom;
		this.periodTo = periodTo;
		this.classesId = classesId;
		this.facultyId = facultyId;
	}

	public int getPeriodId() {
		return periodId;
	}

	public String getPeriodFrom() {
		return periodFrom;
	}

	public String getPeriodTo() {
		return periodTo;
	}

	public int getClassesId() {
		return classesId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	@Override
	public String toString() {
		return "Period [periodId=" + periodId + ", periodFrom=" + periodFrom + ", periodTo=" + periodTo + ", classesId="
				+ classesId + ", facultyId=" + facultyId + "]";
	}
	
	
	
	
}