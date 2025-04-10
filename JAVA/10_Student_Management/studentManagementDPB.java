import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int id;
    double grade;

    Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}

public class studentManagementDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice = 0;

        while (choice != 4) {
            System.out.println("Welcome to the Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Grade");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice: ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = scan.nextLine();

                    System.out.println("Enter student ID:");
                    int id = scan.nextInt();

                    System.out.println("Enter student grade:");
                    double grade = scan.nextDouble();

                    students.add(new Student(name, id, grade));
                    System.out.println("Student added successfully!\n");
                    break;

                case 2:
                    System.out.println("--- Student Records ---");
                    System.out.println("School: Greenwood High School\n");
                    if (students.isEmpty()) {
                        System.out.println("No records found.\n");
                    } else {
                        for (int i = 0; i < students.size(); i++) {
                            System.out.println("Student " + (i + 1) + ":");
                            students.get(i).display();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter student ID to update: ");
                    int updateId = scan.nextInt();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.id == updateId) {
                            System.out.println("Enter new grade: ");
                            s.grade = scan.nextDouble();
                            System.out.println("Grade updated successfully!\n");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student with ID " + updateId + " not found.\n");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        scan.close();
    }
}