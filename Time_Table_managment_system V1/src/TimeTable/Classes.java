package TimeTable;

public class Classes {
	
	private int classesId;
	private String classesName;
	private int departmentId;
	
	public Classes(int classesId, String classesName, int departmentId) {
		super();
		this.classesId = classesId;
		this.classesName = classesName;
		this.departmentId = departmentId;
	}

	public int getclassesId() {
		return classesId;
	}

	public String getclassesName() {
		return classesName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	@Override
	public String toString() {
		return "classes [classesId=" + classesId + ", classesName=" + classesName + ", departmentId=" + departmentId + "]";
	}
	
	
	
	
}
