import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    String name;
    int employeeID;
    double salary;
    String department;

    // Default constructor
    Employee() {
        this.name = "Unknown";
        this.employeeID = 0;
        this.salary = 0.0;
        this.department = "Not Assigned";
    }

    // Parameterized constructor
    Employee(String name, int employeeID, double salary, String department) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
        this.department = department;
    }

    // Display employee information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeID);
        System.out.printf("Salary: $%.2f\n", salary);
        System.out.println("Department: " + department);
    }

    // Calculate annual salary
    public double calculateAnnualSalary() {
        return salary * 12;
    }

    // Raise salary by a given percentage
    public void raiseSalary(double percentage) {
        salary += salary * (percentage / 100);
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        int choice = 0;

        while (choice != 5) {
            System.out.println("Welcome to the Employee Payroll Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Calculate Annual Salary");
            System.out.println("4. Give Salary Raise");
            System.out.println("5. Exit\n");
            System.out.print("Enter your choice: ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter employee name:");
                    String name = scan.nextLine();

                    System.out.println("Enter employee ID:");
                    int id = scan.nextInt();

                    System.out.println("Enter employee salary:");
                    double salary = scan.nextDouble();
                    scan.nextLine();

                    System.out.println("Enter department:");
                    String department = scan.nextLine();

                    employees.add(new Employee(name, id, salary, department));
                    System.out.println("Employee added successfully!\n");
                    break;

                case 2:
                    System.out.println("--- Employee Records ---\n");
                    if (employees.isEmpty()) {
                        System.out.println("No records found.\n");
                    } else {
                        int count = 1;
                        for (Employee emp : employees) {
                            System.out.println("Employee " + count + ":");
                            emp.displayInfo();
                            System.out.println();
                            count++;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter employee ID to calculate salary: ");
                    int searchId = scan.nextInt();
                    boolean found = false;

                    for (Employee emp : employees) {
                        if (emp.employeeID == searchId) {
                            System.out.printf("Annual Salary of %s: $%.2f\n\n", emp.name, emp.calculateAnnualSalary());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee with ID " + searchId + " not found.\n");
                    }
                    break;

                case 4:
                    System.out.println("Enter employee ID to raise salary: ");
                    int raiseId = scan.nextInt();
                    boolean updated = false;

                    for (Employee emp : employees) {
                        if (emp.employeeID == raiseId) {
                            System.out.println("Enter percentage increase: ");
                            double percentage = scan.nextDouble();
                            emp.raiseSalary(percentage);
                            System.out.printf("Salary updated successfully! New Salary: $%.2f\n\n", emp.salary);
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Employee with ID " + raiseId + " not found.\n");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        scan.close();
    }
}
