import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] stocks = {10, 25, 14, 30, 5, 18, 22, 40, 12, 8};
        int highest = stocks[0];
        int lowest = stocks[0];

        System.out.println("Current stock levels: ");
        System.out.println(Arrays.toString(stocks));
        
        System.out.print("Enter the product index to update (0-9):");
        int choice = scan.nextInt();
        System.out.print("Enter the new stock value:");
        int newStock = scan.nextInt();

        stocks[choice] = newStock;

        System.out.println("");
        System.out.println("Updated stock levels: ");
        System.out.println(Arrays.toString(stocks));

        for(int stock:stocks){
            if(stock > highest){
                highest = stock;
            }
            if(stock < highest){
                lowest = stock;
            }
        }

        System.out.println("Highest Stock:" + highest);
        System.out.println("Lowest Stock:" + lowest);
    }
}
