import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Grade");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter grade: ");
                double grade = scanner.nextDouble();
                students.add(new Student(name, grade));
                System.out.println("Student added!");
            } else if (choice == 2) {
                System.out.println("\nStudents List:");
                for (Student s : students) {
                    System.out.println(s.name + " - " + s.grade);
                }
            } else if (choice == 3) {
                System.out.print("Enter student name to update: ");
                String nameToUpdate = scanner.nextLine();
                boolean found = false;
                for (Student s : students) {
                    if (s.name.equals(nameToUpdate)) {
                        System.out.print("Enter new grade: ");
                        s.grade = scanner.nextDouble();
                        System.out.println("Grade updated!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter student name to remove: ");
                String nameToRemove = scanner.nextLine();
                boolean removed = false;
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).name.equals(nameToRemove)) {
                        students.remove(i);
                        System.out.println("Student removed!");
                        removed = true;
                        break;
                    }
                }
                if (!removed) {
                    System.out.println("Student not found.");
                }
            } else if (choice == 5) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
