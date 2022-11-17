package HumanResources;

public class Department {
	String deptID;
	String deptName;
	int numOfStaff;
	
	Department(){}
	
	Department(String deptID, String deptName, int numOfStaff){
		this.deptID = deptID;
		this.deptName = deptName;
		this.numOfStaff = numOfStaff;
	}
	
	void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	
	String getDeptID() {
		return deptID;
	}
	
	void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	String getDeptName() {
		return deptName;
	}
	
	void setNumOfStaff(int numOfStaff) {
		this.numOfStaff = numOfStaff;
	}
	
	int getNumOfStaff() {
		return numOfStaff;
	}
	
	public void displayInformation() {
		System.out.printf("%-12s | ", getDeptID());
		System.out.printf("%-22s | ", getDeptName());
		System.out.println(getNumOfStaff());
	}
}
