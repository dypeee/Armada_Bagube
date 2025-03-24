import java.util.Scanner;

public class SumOfNumbersDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = scan.nextInt();
        int i = 1,result = 0;
        while (i <= num) {
            result+=i;
          
            i++;
        }
        System.out.println("The sum of natural numbers from 1 to 10 is:" + result);
    }
}
