import java.util.Scanner;

public class GradingSystemDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your score:  ");
        int score = scan.nextInt();
        scan.close();
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 75) {
            System.out.println("Grade: B");
        } else if (score >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
        System.out.println("Feedback: Good job!");
    }
}
