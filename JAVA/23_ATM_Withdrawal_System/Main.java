import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] balances = {1000,2000,3000,4000,5000};
        int newBalance;

        System.out.println("Available accounts:");
        System.out.println("[0] Account 1 ");
        System.out.println("[1] Account 2 ");
        System.out.println("[2] Account 3 ");
        System.out.println("[3] Account 4 ");
        System.out.println("[4] Account 5 ");

        System.out.print("Enter account index (0-4):");
        int account = scan.nextInt();

        
        System.out.print("Current balance: " + balances[account]);
        System.out.println(" ");
        System.out.print("Enter transaction type (1-Withdraw, 2-Deposit):");
        int transactionType = scan.nextInt();

        if(transactionType == 1){
            System.out.print("Enter amount to withdraw:");
            int withdraw = scan.nextInt();

            System.out.println(" ");
            System.out.println("Transaction successful!");
            System.out.println("New balance:" + (balances[account] - withdraw));


        }else if(transactionType == 2){
            System.out.print("Enter amount to deposit:");
            int deposit = scan.nextInt();

            System.out.println(" ");
            System.out.println("Transaction successful!");
            System.out.println("New balance:" + (balances[account] + deposit));
        }else{
            System.out.println("Invalid");
        }

    }
}
