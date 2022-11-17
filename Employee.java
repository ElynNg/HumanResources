package HumanResources;
import java.text.NumberFormat;
import java.util.Locale;

public class Employee extends Staff implements ICalculator{
	float overtime;
	final int basicRate = 3000000;
	final int overtimeRate = 200000;
	
	Employee(){}
	
	Employee(String id, String name, int age){
		super(id, name, age);
	}
	
	Employee(String id, String name, int age, float coeffSalary, String incomeDate, Department depts, int offDay, float overtime){
		super(id, name, age, coeffSalary, incomeDate, depts, offDay);
		this.overtime = overtime;
	}
	
	void setOvertime(float overtime) {
		this.overtime = overtime;
	}
	
	float getOvertime() {
		return overtime;
	}
	
	public double calculateSalary() {
		return coeffSalary*basicRate + overtime*overtimeRate;
	}
	
	void displayInformation() {
		double salary = calculateSalary();
		Locale lcl = new  Locale("vn", "VN");
        NumberFormat numF = NumberFormat.getInstance(lcl);
		System.out.print(super.getId() + "\t | ");
		System.out.printf("%-20s  | ", super.getName());
		System.out.print(super.getAge() + "\t | " + super.getCoeffSalary() + "\t\t\t  | ");
		System.out.printf("%-11s | ", super.getIncomeDate());
		System.out.printf("%-25s | ",super.getDept().getDeptName());
		System.out.printf("%-6d | ", super.getOffDay());
		System.out.printf("%-20s | ", getOvertime() );
		System.out.println(numF.format(salary));
		}
}
