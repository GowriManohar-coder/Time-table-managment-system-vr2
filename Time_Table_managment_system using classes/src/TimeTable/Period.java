package TimeTable;

public class Period {
	
	private int periodId;
	private String periodFrom;
	private String periodTo;
	
	public Period(int periodId, String periodFrom, String periodTo) {
		super();
		this.periodId = periodId;
		this.periodFrom = periodFrom;
		this.periodTo = periodTo;
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

	@Override
	public String toString() {
		return "Period [periodId=" + periodId + ", periodFrom=" + periodFrom + ", periodTo=" + periodTo + "]";
	}
	
	
	

}
