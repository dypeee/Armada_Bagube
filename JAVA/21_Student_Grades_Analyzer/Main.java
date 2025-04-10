import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] grades;
        double average;
        int totalGrades = 0;

        System.out.print("Enter the number of students: ");
        int studentNum = scan.nextInt();
        grades = new int[studentNum];

        System.out.print("Enter grade for student 1: ");
        grades[0] = scan.nextInt();
        int highestGrade = grades[0];
        int lowestGrade = grades[0];
        totalGrades += grades[0];

        for (int i = 1; i < studentNum; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scan.nextInt();
            totalGrades += grades[i];

            if (grades[i] > highestGrade) {
                highestGrade = grades[i];
            }
            if (grades[i] < lowestGrade) {
                lowestGrade = grades[i];
            }
        }

        average = totalGrades / studentNum;

        System.out.println("Highest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
        System.out.println("Average Grade: " + average);

        scan.close();
    }
}
