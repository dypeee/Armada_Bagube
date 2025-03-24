import java.util.Scanner;

public class LargestNumberFinderDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean exit = true;
        int largest = 0;
        while (exit) {
            System.out.print("Enter a number (-1 to stop): ");
            int num = scan.nextInt();
            if (num > largest) {
                largest = num;
            }
            if (num == -1) {
                exit = false;
            }
        }
        System.out.println("The largest number entered is:" + largest);
    }
}
