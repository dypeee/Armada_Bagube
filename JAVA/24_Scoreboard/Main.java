import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int studentInput = scan.nextInt();
        System.out.print("Enter the number of subjects: ");
        int subjectInput = scan.nextInt();

        int[][] matrix = new int[studentInput][subjectInput];

        System.out.println();

        for (int i = 0; i < studentInput; i++) {
            System.out.print("Enter scores for Student " + (i + 1) + ": ");
            for (int j = 0; j < subjectInput; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        
        
        System.out.println();
        
        for (int i = 0; i < studentInput; i++) {
            int total = 0;
            for (int j = 0; j < subjectInput; j++) {
                total += matrix[i][j];
            }
            double average = total / subjectInput;
            System.out.println("Student " + (i + 1) + " - Total: " + total + ", Average: " + String.format("%.2f", average));
        }

        scan.close();
    }
}
