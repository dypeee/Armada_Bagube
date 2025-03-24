import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class StudentGradesAnalyzer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> grades = new ArrayList<>();

        System.out.print("Number of students: ");
        int num = scan.nextInt();

        
        System.out.print("Enter grade for student 1: ");
        float firstGrade = scan.nextInt();
        float totalGrades = firstGrade;
        float averageGrade = 0;
        float highestGrade = firstGrade;
        float lowestGrade = firstGrade;

        for (int i = 2; i <= num; i++) {
            System.out.print("Enter grade for student " + i + ": ");
            int gradeInput = scan.nextInt();
            grades.add(gradeInput);
        }

        for (int grade : grades) {
            totalGrades += grade;
            
            if(grade > highestGrade){
                highestGrade = grade;
            }
            if(grade < lowestGrade){
                lowestGrade = grade;
            } 
        }
        
        averageGrade = totalGrades/num;
        System.out.println("=== Grade Analysis === ");
        System.out.println("Total Grades: " + totalGrades);
        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Highest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
        scan.close();
    }
}
