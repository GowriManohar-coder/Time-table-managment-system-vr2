package TimeTable;

public class Days {
	
	private int daysId;
	private int daysName;
	
	public Days(int daysId, int daysName) {
		super();
		this.daysId = daysId;
		this.daysName = daysName;
	}

	public int getDaysId() {
		return daysId;
	}

	public int getDaysName() {
		return daysName;
	}

	@Override
	public String toString() {
		return "Days [daysId=" + daysId + ", daysName=" + daysName + "]";
	}
	
	
}