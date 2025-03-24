import java.util.Scanner;

public class ElectricityBillDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Number of Units:  ");
        int unit = scan.nextInt();
        scan.close();
        double billAmount = 0;
        if (unit <= 100) {
            billAmount = unit * 1.50;
        } else if (unit <= 300) {
            billAmount = (100 * 1.50) + ((unit - 100) * 2.50);
        } else {
            billAmount = (100 * 1.50) + (200 * 2.50) + ((unit - 300) * 3.50);
        }
        System.out.println("Total bill: " + billAmount);
        
    }
}
