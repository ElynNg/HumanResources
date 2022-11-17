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
		int menuNumber; //số người dùng nhập trong menu
		
		boolean exit = false;
		
		createInformation(staffs, depts, managerTitle);
		
		Scanner input = new Scanner(System.in);
		while(exit == false){
    		menuNumber = displayMenu(input);
    
    		while (menuNumber < 1 && menuNumber > 8) {
    			System.out.println("Số bạn nhập không có trong menu");
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
    				//XEM LẠI THÔNG TIN NHÂN VIÊN ĐÃ NHẬP
    				System.out.println("1. Xem danh sách nhân viên hiện có");
    				System.out.println("2. Chỉ xem thông tin nhân viên vừa nhập");
    				System.out.println("3. Thoát");
    				System.out.println("Bạn chọn: ");
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
    						System.out.println("Nhập lại:");
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
	
	//0. KHỞI TẠO CÁC THÔNG TIN NHÂN VIÊN
		static void createInformation(ArrayList<Staff> staffs, ArrayList<Department> depts, ArrayList<String> managerTitle) {
			//KHỞI TẠO DANH SÁCH CHỨC DANH
			managerTitle.add("Business Leafer");
			managerTitle.add("Project Leader");
			managerTitle.add("Technical Leader");
			
			//KHỞI TẠO DANH SÁCH BỘ PHẬN
			Department hr = new Department("hr", "Human Resource", 3);
			Department it = new Department("it", "Information Technology", 3);
			Department mkt = new Department("mkt", "Marketing", 5);
			
			depts.add(hr);
			depts.add(it);
			depts.add(mkt);
			
			//KHỞI TẠO DANH SÁCH NHÂN VIÊN
			Employee staff_1 = new Employee("E001", "NGUYEN VAN A", 28, 3.2f, "10.10.2010", hr, 10, 5.5f);
			Employee staff_2 = new Employee("E002", "TRAN THI B", 24, 2.2f, "09.10.2019", hr, 7, 10.5f);
			
			staffs.add(staff_1);
			staffs.add(staff_2);
			
			//KHỞI TẠO DANH SÁCH QUẢN LÝ
			Manager manager_1 = new Manager("M001", "LE THI C", 25, (float)2.5, "11.11.2010", it, 5, "Business Leader");
			Manager manager_2 = new Manager("M002", "TA VAN LUC", 32, (float)4.5, "01.11.2010", it, 1, "Technical Leader");
			
			staffs.add(manager_1);
			staffs.add(manager_2);
		}
		
	//0.1 HIỂN THỊ RA MÀN HÌNH MENU CÁC CHỨC NĂNG
		static int displayMenu(Scanner input) {
			System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
			System.out.println("2. Hiển thị các bộ phận trong công ty");
			System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
			System.out.println("4. Thêm nhân viên mới vào công ty");
			System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc ID");
			System.out.println("6. Hiển thị bảng lương nhân viên của toàn công ty");
			System.out.println("7. Hiển thị bảng lương nhân viên theo thứ tự tăng dần");
			System.out.println("8. Hiển thị bảng lương nhân viên theo thứ tự giảm dần");
			System.out.println("9. Thoát chương trình");
			System.out.println("Lựa chọn của bạn là: ");
			int menuNumber = (int)input.nextInt();
			return menuNumber;
		}
	
	//1. HIỂN THỊ DANH SÁCH NHÂN VIÊN HIỆN CÓ TRONG CÔNG TY
		static void displayListOfExistingStaff(ArrayList<Staff> staffs) {
			System.out.println("Danh sách nhân viên hiện có trong công ty:");
			System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < staffs.size(); i++) {
				staffs.get(i).displayInformation();
			}
		}
		
	//2. HIỂN THỊ DANH SÁCH BỘ PHẬN TRONG CÔNG TY
		static void displayDepartment(ArrayList<Department> depts) {
			System.out.println("Danh sách các bộ phận: ");
			System.out.println("Departmen ID | Department Name        | Number of Staffs");
			System.out.println("----------------------------------------------------------");
			
			for (int i = 0; i < depts.size(); i++) {
				depts.get(i).displayInformation();
			}
		}
	//3. HIỂN THỊ DANH SÁCH NHÂN VIÊN THEO BỘ PHẬN
		static void displayStaffbyDepartment(ArrayList<Staff> staffs, ArrayList<Department> depts) {
			System.out.println("Danh sách nhân viên theo bộ phận: ");
			for (int i = 0; i < depts.size(); i++) {
				System.out.println("Danh sách nhân viên trong bộ phận " + depts.get(i).getDeptName() + ": ");
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
	//4. THÊM NHÂN VIÊN MỚI VÀO CÔNG TY
		static void addStaff(ArrayList<Staff> staffs, ArrayList<Department> depts,ArrayList<String> managerTitle) {
			int addStaffNumber; //số người dùng nhập trong mục thêm nhân viên
			boolean pass = false;
			Scanner input = new Scanner(System.in);
			
			addStaffNumber = menuAddStaff(input);
			while (addStaffNumber != 1 && addStaffNumber != 2) {
				System.out.println("Số bạn nhập không có trong menu");
				addStaffNumber = menuAddStaff(input);
			}
			
			System.out.println("Lựa chọn của bạn là: " + addStaffNumber);
			
			//NHẬP ID
			System.out.println("Nhập ID: ");
			String id = input.nextLine();
			
			//KIỂM TRA XEM ID CÓ TRÙNG HAY KHÔNG
			while (pass == false) {
				for (int i = 0; i < staffs.size(); i++) {
					if (id.equalsIgnoreCase(staffs.get(i).getId())){
						System.out.println("ID đã được sử dụng");
						System.out.println("Nhập lại: ");
						id = input.nextLine();
						break;
					}
					else if (i == (staffs.size() - 1)){
						pass = true;
					}
				}
			};
			
			//NHẬP TÊN 
			System.out.println("Nhập tên: ");
			String name = input.nextLine();
			name = name.toUpperCase();
			
			//NHẬP TUỔI
			System.out.println("Nhập tuổi: ");
			int age = input.nextInt();
			
			//NHẬP HỆ SỐ LƯƠNG
			System.out.println("Nhập hệ số lương: ");
			float coeffSalary = input.nextFloat();
			input.nextLine();
			
			//NHẬP NGÀY VÀO LÀM
			System.out.println("Nhập ngày vào làm: ");
			String incomeDate = input.next();
			
			//NHẬP SỐ NGÀY NGHỈ PHÉP
			System.out.println("Nhập số ngày nghỉ phép: ");
			int offDay = (int)input.nextInt();
			
			//NHẬP BỘ PHẬN
			int addDepartmentNumber = displayDepartmentMenu(input);
			
			if (addStaffNumber == 1) {
				addGeneralStaff(staffs, depts, input, id, name, age, coeffSalary, incomeDate, offDay, addDepartmentNumber);
			}
			else {
				addManager(staffs, depts, managerTitle, addDepartmentNumber, input, id, name, age, coeffSalary, incomeDate, offDay);
			}
			
			
		}
		
	//4.0 HIỂN THỊ MENU CHỌN NHÂN VIÊN
		static int menuAddStaff(Scanner input) {
			System.out.println("1. Thêm nhân viên thông thường");
			System.out.println("2. Thêm nhân viên quản lý");
			int num = input.nextInt();
			input.nextLine();
			return num;
		}
		
	//4.1 HIỂN THỊ DANH SÁCH BỘ PHẬN
		static int displayDepartmentMenu(Scanner input) {
			System.out.println("1. HR - Human Resources");
			System.out.println("2. IT - Information Technology");
			System.out.println("3. MKT - Marketing");
			System.out.println("Bạn chọn: ");
			int num = input.nextInt();
			while (num != 1 && num != 2 && num !=3 ) {
				System.out.println("Số bạn chọn không có trong menu");
				num = input.nextInt();
			}
			return num;
		}
		
	//4.2 THÊM NHÂN VIÊN THÔNG THƯỜNG
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
			}
			else if (num == 2) {
				newStaff.setDept(depts.get(1));
			}
			else {
				newStaff.setDept(depts.get(2));
			}
			
			//NHẬP SỐ GIỜ LÀM THÊM 
			System.out.println("Nhập số giờ làm thêm: ");
			float overtime = input.nextFloat();
			newStaff.setOvertime(overtime);
			
			staffs.add(newStaff);
		}
		
	//4.3 THÊM NHÂN VIÊN QUẢN LÝ
		static void addManager(ArrayList<Staff> staffs, ArrayList<Department> depts,ArrayList<String> managerTitle, int num, Scanner input, String id, String name, int age, float coeffSalary, String incomeDate, int offDay) {
			Manager newManager = new Manager();
			
			newManager.setId(id);
			newManager.setName(name);
			newManager.setAge(age);
			newManager.setCoeffSalary(coeffSalary);
			newManager.setIncomeDate(incomeDate);
			if (num == 1) {
				newManager.setDept(depts.get(0));
			}
			else if (num == 2) {
				newManager.setDept(depts.get(1));
			}
			else {
				newManager.setDept(depts.get(2));
			}
			
			//NHẬP CHỨC DANH
			System.out.println("Chức danh: ");
			System.out.println("1. Business Leader");
			System.out.println("2. Project Leader");
			System.out.println("3. Technical Leader");
			System.out.println("Nhập chức danh: ");
			int addTitleNumber = input.nextInt();
			while (addTitleNumber != 1 && addTitleNumber != 2 && addTitleNumber != 3) {
				System.out.println("Số bạn nhập không có trong menu");
				System.out.println("Nhập lại: ");
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
	
	//5. TÌM KIẾM THÔNG TIN NHÂN VIÊN THEO TÊN HOẶC ID
		static void searchForStaffByNameOrID(ArrayList<Staff> staffs) {
			Scanner input = new Scanner(System.in);
			System.out.println("1. Tìm nhân viên theo tên");
			System.out.println("2. Tìm nhân viên theo ID");
			System.out.println("Bạn chọn: ");
			int searchStaffNumber = input.nextInt();
			
			while (searchStaffNumber != 1 && searchStaffNumber != 2) {
				System.out.println("Số không có trong menu");
				System.out.println("Nhập lại: ");
				searchStaffNumber = input.nextInt();
			}
			
			if (searchStaffNumber == 1) {
				boolean check = false;
				System.out.println("Nhập tên nhân viên cần tìm");
				String staffName = input.next().toUpperCase();
				
				for (int i = 0; i < staffs.size(); i++) {
					if (staffs.get(i).getName().contains(staffName)) {
						System.out.println("Kết quả: ");
						System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
						System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
						staffs.get(i).displayInformation();
						check = true;
					}
				}
				if (check == false) {
					System.out.println("Không tìm thấy");
				}
			}
			else {
				boolean check = false;
				System.out.println("Nhập ID nhân viên cần tìm: ");
				String id = input.next();
				input.nextLine();
				for (int i = 0; i < staffs.size(); i++) {
					if (staffs.get(i).getId().equalsIgnoreCase(id)) {
						System.out.println("Kết quả: ");
						System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
						System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
						staffs.get(i).displayInformation();
						check = true;
					}
				}
				if (check == false) {
					System.out.println("Không tìm thấy");
				}
				
			}
		}
		
	//6. HIỂN THỊ BẢNG LƯƠNG NHÂN VIÊN TOÀN BỘ CÔNG TY
		static void displayAllStaffSalary(ArrayList<Staff> staffs) {
			System.out.println("BẢNG LƯƠNG CỦA NHÂN VIÊN TOÀN CÔNG TY:");
			System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < staffs.size(); i++) {
				staffs.get(i).displayInformation();
			}
		}
	
	//7. HIỂN THỊ BẢNG LƯƠNG THEO THỨ TỰ TĂNG DẦN
		static void displaySalaryInAscending(ArrayList<Staff> staffs) {
			Collections.sort(staffs, new Comparator<Staff>() {
                @Override
                public int compare(Staff staff_1, Staff staff_2) {
                    return (int)(((ICalculator)staff_1).calculateSalary() - ((ICalculator)staff_2).calculateSalary());
                }
            });
			
			System.out.println("BẢNG LƯƠNG NHÂN VIÊN THEO THỨ TỰ TĂNG DẦN: ");
			System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			
			
			for (int i = 0; i < staffs.size(); i++) {
				staffs.get(i).displayInformation();
			}
			
		}
	
	//8. HIỂN THỊ BẢNG LƯƠNG THEO THỨ TỰ GIẢM DẦN
		static void displaySalaryInDescending(ArrayList<Staff> staffs) {
			Collections.sort(staffs, new Comparator<Staff>() {
                @Override
                public int compare(Staff staff_1, Staff staff_2) {
                    return (int)(((ICalculator)staff_2).calculateSalary() - ((ICalculator)staff_1).calculateSalary());
                }
            });
			
			System.out.println("BẢNG LƯƠNG NHÂN VIÊN THEO THỨ TỰ TĂNG DẦN: ");
			System.out.println("ID\t | NAME \t\t | AGE\t | COEFFICIENT OF SALARY  | INCOME DATE | DEPARTMENT \t\t    | OFFDAY | OVERTIME/ TITLE      | SALARY");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			
			
			for (int i = 0; i < staffs.size(); i++) {
				staffs.get(i).displayInformation();
			}
		}
}