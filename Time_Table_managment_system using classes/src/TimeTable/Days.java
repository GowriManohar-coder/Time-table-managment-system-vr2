package TimeTable;

public class Days {
	
	private int daysId;
	private int daysName;
	private int periodId;
	
	public Days(int daysId, int daysName, int periodId) {
		super();
		this.daysId = daysId;
		this.daysName = daysName;
		this.periodId = periodId;
	}

	public int getDaysId() {
		return daysId;
	}

	public int getDaysName() {
		return daysName;
	}

	public int getPeriodId() {
		return periodId;
	}

	@Override
	public String toString() {
		return "Days [daysId=" + daysId + ", daysName=" + daysName + ", periodId=" + periodId + "]";
	}
	
	
	
}