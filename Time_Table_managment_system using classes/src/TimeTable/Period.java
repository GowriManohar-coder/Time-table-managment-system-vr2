package TimeTable;

public class Period {
	
	private int periodId;
	private int periodFrom;
	private int periodTo;
	
	public Period(int periodId, int periodFrom, int periodTo) {
		super();
		this.periodId = periodId;
		this.periodFrom = periodFrom;
		this.periodTo = periodTo;
	}

	public int getPeriodId() {
		return periodId;
	}

	public int getPeriodFrom() {
		return periodFrom;
	}

	public int getPeriodTo() {
		return periodTo;
	}

	@Override
	public String toString() {
		return "Period [periodId=" + periodId + ", periodFrom=" + periodFrom + ", periodTo=" + periodTo + "]";
	}
	
	

}
