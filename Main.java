package HumanResources;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		ArrayList<Staff> staffs = new ArrayList<>();
		ArrayList<Department> depts = new ArrayList<>();
		ArrayList<String> managerTitle = new ArrayList<>();
		int menuNumber;
		
		boolean exit = false;
		
		createInformation(staffs, depts, managerTitle);
		
		Scanner input = new Scanner(System.in);
		while(exit == false){
    		menuNumber = displayMenu(input);
    
    		while (menuNumber < 1 && menuNumber > 9) {
    			System.out.println("Incorrect number");
    			menuNumber = displayMenu(input);
    		}
    		
    		switch (menuNumber) {
    		case 1:
    			displayListOfExistingStaff(staffs);
    			break;
    		case 2:
    			displayDepartment(depts);
    			break;
    		case 3:
    			displayStaffbyDepartment(staffs, depts);
    			break;
    		case 4:
    			addStaff(staffs,depts, managerTitle);
    				//View updated staff information
    				System.out.println("1. View updated list of employees");
    				System.out.println("2. Only view entered employee");
    				System.out.println("3. Skip");
    				System.out.println("Your choice is: ");
    				int checkStaffInformation = input.nextInt();
    				switch (checkStaffInformation) {
    					case 1: 
    						displayListOfExistingStaff(staffs);
    						break;
    					case 2: 
    						staffs.get(staffs.size()-1).displayInformation();
    						break;
    					case 3:
    						break;
    					default: 
    						System.out.println("Incorrect number. Please enter the correct number.");
    						break;
    				}
    			break;
    		case 5: 
    			searchForStaffByNameOrID(staffs);
    			break;
    		case 6: 
    			displayAllStaffSalary(staffs);
    			break;
    		case 7:
    			displaySalaryInAscending(staffs);
    			break;
    		case 8:
    			displaySalaryInDescending(staffs);
    			break;
    		case 9:
    			exit = true;
    			break;
    		}
		}
	}
	
	//0. CREATE STAFF INFORMATION
		static void createInformation(ArrayList<Staff> staffs, ArrayList<Department> depts, ArrayList<String> managerTitle) {
			//CREATE LIST OF MANAGER TITLE
			managerTitle.add("Business Leafer");
			managerTitle.add("Project Leader");
			managerTitle.add("Technical Leader");
			
			//CREATE LIST OF DEPARTMENT
			Department hr = new Department("hr", "Human Resource", 2);
			Department it = new Department("it", "Information Technology", 2);
			Department mkt = new Department("mkt", "Marketing", 0);
			
			depts.add(hr);
			depts.add(it);
			depts.add(mkt);
			
			//CREATE LIST OF STAFF
			Employee staff_1 = new Employee("E001", "NGUYEN VAN A", 28, 3.2f, "10.10.2010", hr, 10, 5.5f);
			Employee staff_2 = new Employee("E002", "TRAN THI B", 24, 2.2f, "09.10.2019", hr, 7, 10.5f);
			
			staffs.add(staff_1);
			staffs.add(staff_2);
			
			//CREATE LIST OF MANAGER
			Manager manager_1 = new Manager("M001", "LE THI C", 25, (float)2.5, "11.11.2010", it, 5, "Business Leader");
			Manager manager_2 = new Manager("M002", "TA VAN LUC", 32, (float)4.5, "01.11.2010", it, 1, "Technical Leader");
			
			staffs.add(manager_1);
			staffs.add(manager_2);
		}
		
	//0.1 DISPLAY LIST OF FUNCTION
		static int displayMenu(Scanner input) {
			System.out.println("1. Display the list of existing employees in the company");
			System.out.println("2. Display list of departments in the company");
			System.out.println("3. Display employees by department");
			System.out.println("4. Add new employee to the company");
			System.out.println("5. Search for employee information by Name or ID");
			System.out.println("6. Display payroll of employees throughout the company");
			System.out.println("7. Display employee payroll in ascending order");
			System.out.println("8. Display employee payroll in descending order");
			System.out.println("9. Exit the program");
			System.out.println("Your choice is: ");
			int menuNumber = (int)input.nextInt();
			return menuNumber;
		}
	
	//1. DISPLAY LIST OF EXISTING STAFFS
		static void displayListOfExistingStaff(ArrayList<Staff> staffs) {
			System.out.println("List of existing employees in the company:");
			System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < staffs.size(); i++) {
				staffs.get(i).displayInformation();
			}
		}
		
	//2. DISPLAY LIST OF DEPARTMENT
		static void displayDepartment(ArrayList<Department> depts) {
			System.out.println("List departments in the company: ");
			System.out.println("Departmen ID | Department Name        | Number of Staffs");
			System.out.println("----------------------------------------------------------");
			
			for (int i = 0; i < depts.size(); i++) {
				depts.get(i).displayInformation();
			}
		}
	//3. DISPLAY LIST OF STAFF BY DEPARTMENT
		static void displayStaffbyDepartment(ArrayList<Staff> staffs, ArrayList<Department> depts) {
			System.out.println("List employees by department: ");
			for (int i = 0; i < depts.size(); i++) {
				System.out.println("List of employee in " + depts.get(i).getDeptName() + "department: ");
				System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
				for (int j = 0; j < staffs.size(); j++) {
					if (staffs.get(j).getDept().getDeptName().equals(depts.get(i).getDeptName())) {    ///*****
						staffs.get(j).displayInformation();
					}
				}
				System.out.println();
			}
		}
	//4. ADD NEW STAFF
		static void addStaff(ArrayList<Staff> staffs, ArrayList<Department> depts,ArrayList<String> managerTitle) {
			int addStaffNumber; //ADD NEW STAFF
			boolean pass = false;
			Scanner input = new Scanner(System.in);
			
			addStaffNumber = menuAddStaff(input);
			while (addStaffNumber != 1 && addStaffNumber != 2) {
				System.out.println("Incorrect number");
				addStaffNumber = menuAddStaff(input);
			}
			
			System.out.println("Your choice is: " + addStaffNumber);
			
			//ENTER NEW STAFF ID
			System.out.println("Enter ID: ");
			String id = input.nextLine();
			
			//CHECK IF THIS ID IS ALREADY EXISTS
			while (pass == false) {
				for (int i = 0; i < staffs.size(); i++) {
					if (id.equalsIgnoreCase(staffs.get(i).getId())){
						System.out.println("ID has already exists");
						System.out.println("Enter the correct ID: ");
						id = input.nextLine();
						break;
					}
					else if (i == (staffs.size() - 1)){
						pass = true;
					}
				}
			};
			
			//ENTER NEW STAFF NAME
			System.out.println("Enter name: ");
			String name = input.nextLine();
			name = name.toUpperCase();
			
			//AGE
			System.out.println("Age: ");
			int age = input.nextInt();
			
			//COEFFICIENT OF SALARY
			System.out.println("Coefficient of salary: ");
			float coeffSalary = input.nextFloat();
			input.nextLine();
			
			//ENTER INCOME DATE
			System.out.println("Income Date: ");
			String incomeDate = input.next();
			
			//ENTER STAFF OFF DAY
			System.out.println("Off Day: ");
			int offDay = (int)input.nextInt();
			
			//SELECT STAFF DEPARTMENT
			int addDepartmentNumber = displayDepartmentMenu(input);
			
			if (addStaffNumber == 1) {
				addGeneralStaff(staffs, depts, input, id, name, age, coeffSalary, incomeDate, offDay, addDepartmentNumber);
			}
			else {
				addManager(staffs, depts, managerTitle, addDepartmentNumber, input, id, name, age, coeffSalary, incomeDate, offDay);
			}
			
			
		}
		
	//4.0 DISPLAY SELECT KIND OF STAFF MENU
		static int menuAddStaff(Scanner input) {
			System.out.println("1. Add general staff");
			System.out.println("2. Add manager");
			int num = input.nextInt();
			input.nextLine();
			return num;
		}
		
	//4.1 DISPLAY LIST OF DEPARTMENT
		static int displayDepartmentMenu(Scanner input) {
			System.out.println("1. HR - Human Resources");
			System.out.println("2. IT - Information Technology");
			System.out.println("3. MKT - Marketing");
			System.out.println("Your choice is: ");
			int num = input.nextInt();
			while (num != 1 && num != 2 && num !=3 ) {
				System.out.println("Incorrect number");
				num = input.nextInt();
			}
			return num;
		}
		
	//4.2 ADD GENERAL STAFF
		static void addGeneralStaff(ArrayList<Staff> staffs, ArrayList<Department> depts, Scanner input, String id, String name, int age, float coeffSalary, String incomeDate, int offDay, int num) {
			Employee newStaff = new Employee();
			
			newStaff.setId(id);
			newStaff.setName(name);
			newStaff.setAge(age);
			newStaff.setCoeffSalary(coeffSalary);
			newStaff.setIncomeDate(incomeDate);
			newStaff.setOffDay(offDay);
			if (num == 1) {
				newStaff.setDept(depts.get(0));
				depts.get(0).numOfStaff++;
			}
			else if (num == 2) {
				newStaff.setDept(depts.get(1));
				depts.get(1).numOfStaff++;
			}
			else {
				newStaff.setDept(depts.get(2));
				depts.get(2).numOfStaff++;
			}
			
			//ENTER THE NUMBER OF OVERTIME HOURS
			System.out.println("Overtime: ");
			float overtime = input.nextFloat();
			newStaff.setOvertime(overtime);
			
			staffs.add(newStaff);
		}
		
	//4.3 ADD MANAGER
		static void addManager(ArrayList<Staff> staffs, ArrayList<Department> depts,ArrayList<String> managerTitle, int num, Scanner input, String id, String name, int age, float coeffSalary, String incomeDate, int offDay) {
			Manager newManager = new Manager();
			
			newManager.setId(id);
			newManager.setName(name);
			newManager.setAge(age);
			newManager.setCoeffSalary(coeffSalary);
			newManager.setIncomeDate(incomeDate);
			if (num == 1) {
				newManager.setDept(depts.get(0));
				depts.get(0).numOfStaff++;
			}
			else if (num == 2) {
				newManager.setDept(depts.get(1));
				depts.get(1).numOfStaff++;
			}
			else {
				newManager.setDept(depts.get(2));
				depts.get(1).numOfStaff++;
			}
			
			//NHẬP CHỨC DANH
			System.out.println("Manager's title: ");
			System.out.println("1. Business Leader");
			System.out.println("2. Project Leader");
			System.out.println("3. Technical Leader");
			System.out.println("Enter the title: ");
			int addTitleNumber = input.nextInt();
			while (addTitleNumber != 1 && addTitleNumber != 2 && addTitleNumber != 3) {
				System.out.println("Incorrect number");
				addTitleNumber = input.nextInt();			}
			if (addTitleNumber == 1) {
				newManager.setTitle("Business Leader");
			}
			else if (addTitleNumber == 2) {
				newManager.setTitle("Project Leader");
			}
			else {
				newManager.setTitle("Technical Leader");
			}
			
			staffs.add(newManager);
		}
	
	//5. SEARCH FOR STAFF BY NAME OR ID 
		static void searchForStaffByNameOrID(ArrayList<Staff> staffs) {
			Scanner input = new Scanner(System.in);
			System.out.println("1. Search for staff by Name");
			System.out.println("2. Search for staff by ID");
			System.out.println("Your choice is: ");
			int searchStaffNumber = input.nextInt();
			
			while (searchStaffNumber != 1 && searchStaffNumber != 2) {
				System.out.println("Incorrect number");
				searchStaffNumber = input.nextInt();
			}
			
			if (searchStaffNumber == 1) {
				boolean check = false;
				System.out.println("Enter the name of the staff you're looking for: ");
				String staffName = input.next().toUpperCase();
				
				for (int i = 0; i < staffs.size(); i++) {
					if (staffs.get(i).getName().contains(staffName)) {
						System.out.println("Result: ");
						System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
						System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
						staffs.get(i).displayInformation();
						check = true;
					}
				}
				if (check == false) {
					System.out.println("Not found");
				}
			}
			else {
				boolean check = false;
				System.out.println("Enter the ID of the staff you're looking for: ");
				String id = input.next();
				input.nextLine();
				for (int i = 0; i < staffs.size(); i++) {
					if (staffs.get(i).getId().equalsIgnoreCase(id)) {
						System.out.println("Result: ");
						System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
						System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
						staffs.get(i).displayInformation();
						check = true;
					}
				}
				if (check == false) {
					System.out.println("Not found");
				}
				
			}
		}
		
	//6. DISPLAY ALL STAFF SALARY
		static void displayAllStaffSalary(ArrayList<Staff> staffs) {
			System.out.println("ALL STAFF SALARY:");
			System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < staffs.size(); i++) {
				staffs.get(i).displayInformation();
			}
		}
	
	//7. DISPLAY STAFF SALARY IN ASCENDING
		static void displaySalaryInAscending(ArrayList<Staff> staffs) {
			Collections.sort(staffs, new Comparator<Staff>() {
                @Override
                public int compare(Staff staff_1, Staff staff_2) {
                    return (int)(((ICalculator)staff_1).calculateSalary() - ((ICalculator)staff_2).calculateSalary());
                }
            });
			
			System.out.println("STAFF SALARY IN ASCENDING: ");
			System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			
			
			for (int i = 0; i < staffs.size(); i++) {
				staffs.get(i).displayInformation();
			}
			
		}
	
	//8. DISPLAY STAFF SALARY IN DESCENDING
		static void displaySalaryInDescending(ArrayList<Staff> staffs) {
			Collections.sort(staffs, new Comparator<Staff>() {
                @Override
                public int compare(Staff staff_1, Staff staff_2) {
                    return (int)(((ICalculator)staff_2).calculateSalary() - ((ICalculator)staff_1).calculateSalary());
                }
            });
			
			System.out.println("STAFF SALARY IN DESCENDING: ");
			System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			
			
			for (int i = 0; i < staffs.size(); i++) {
				staffs.get(i).displayInformation();
			}
		}
}
