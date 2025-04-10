import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    double average;

    public double calculateAverage(List<Integer> grades) {
        double total = 0;
        for (int grade : grades) {
            total += grade;
        }
        average = total / grades.size();
        return average;
    }

    public String classifyAverage() {
        if (average >= 90) {
            return "Excellent";
        } else if (average >= 75) {
            return "Good";
        } else if (average >= 50) {
            return "Average";
        } else {
            return "Fail";
        }
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Average Grade: " + average);
        System.out.println("Performance: " + classifyAverage());
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> grades = new ArrayList<>();

        System.out.print("Enter student name: ");
        String name = scan.nextLine();

        System.out.println("Enter 3 grades:");
        for (int i = 0; i < 3; i++) {
            grades.add(scan.nextInt());
        }

        Student student = new Student();
        student.name = name; 
        student.calculateAverage(grades);
        
        student.displayDetails();

        scan.close();
    }
}
