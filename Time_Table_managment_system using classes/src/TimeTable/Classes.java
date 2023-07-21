package TimeTable;

public class Classes {
	
	private int classId;
	private String className;
	private int departmentId;
	
	public Classes(int classId, String className, int departmentId) {
		super();
		this.classId = classId;
		this.className = className;
		this.departmentId = departmentId;
	}

	public int getClassId() {
		return classId;
	}

	public String getClassName() {
		return className;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + ", departmentId=" + departmentId + "]";
	}
	
	
	
	
}
