package HumanResources;

import java.text.NumberFormat;
import java.util.Locale;

public class Manager extends Staff implements ICalculator{
	String title; 
	final int basicRate = 5000000;
	int managerBonus;
	double salary;
	
	Manager(){}
	
	Manager(String id, String name, int age){
		super(id, name, age);
	}
	
	Manager(String id, String name, int age, float coeffSalary, String incomeDate, Department dept, int offDay, String title){
		super(id, name, age, coeffSalary, incomeDate, dept, offDay);
		this.title = title;
	}
	
	void setTitle(String title) {
		this.title = title;
	}
	
	String getTitle() {
		return title;
	}
	
	void managerBonus() {
		if (this.title.equalsIgnoreCase("Business Leader")){
			this.managerBonus = 8000000;
		} else if (this.title.equalsIgnoreCase("Project Leader")) {
			this.managerBonus = 5000000; 
		}
		else if (this.title.equalsIgnoreCase("Technical Leader")) {
			this.managerBonus = 6000000; 
		}
	}
	
	void displayInformation() {
		salary = calculateSalary();
		Locale lcl = new  Locale("vn", "VN");
        NumberFormat numF = NumberFormat.getInstance(lcl);
		System.out.print(super.getId() + "\t | ");
		System.out.printf("%-20s  | ", super.getName());
		System.out.print(super.getAge() + "\t | " + super.getCoeffSalary() + "\t\t\t  | ");
		System.out.printf("%-11s | ", super.getIncomeDate());
		System.out.printf("%-25s | ",super.getDept().getDeptName());
		System.out.printf("%-6d | ", super.getOffDay());
		System.out.printf("%-20s | ", getTitle() );
		System.out.println(numF.format(salary));
		}
	
	public double calculateSalary() {
		this.managerBonus();
		return coeffSalary * basicRate + this.managerBonus;
	}
}
