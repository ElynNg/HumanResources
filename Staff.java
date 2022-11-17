package HumanResources;

public abstract class Staff {
	String id;
	String name;
	int age;
	float coeffSalary;
	String incomeDate;
	Department dept;
	int offDay;
	
	Staff(){}
	
	Staff(String id, String name, int age){
		this.id = id;
		this.name= name;
		this.age = age;
	}
	
	Staff(String id, String name, int age, float coeffSalary, String incomeDate, Department dept, int offDay){
		this.id = id;
		this.name = name; 
		this.age = age;
		this.coeffSalary = coeffSalary;
		this.incomeDate = incomeDate;
		this.dept = dept;
		this.offDay = offDay;
	}

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	float getCoeffSalary() {
		return coeffSalary;
	}

	void setCoeffSalary(float coeffSalary) {
		this.coeffSalary = coeffSalary;
	}

	String getIncomeDate() {
		return incomeDate;
	}

	void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}

	Department getDept() {
		return dept;
	}

	void setDept(Department dept) {
		this.dept = dept;
	}

	int getOffDay() {
		return offDay;
	}

	void setOffDay(int offDay) {
		this.offDay = offDay;
	}
	
	abstract void displayInformation();
	
	abstract double calculateSalary();
	
	abstract void sort();
}