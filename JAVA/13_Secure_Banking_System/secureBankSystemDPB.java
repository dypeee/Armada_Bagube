import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String[] transactionHistory;
    private double interestRate;
    private int transactionCount;

    BankAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        this.setAccountNumber(accountNumber);
        this.setAccountHolder(accountHolder);
        this.setBalance(balance);
        this.interestRate = interestRate;
        this.transactionHistory = new String[100];
        this.transactionCount = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber.matches("\\d{10}")) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Account number must be exactly 10 digits.");
        }
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Account holder name cannot be null or empty.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance must be a positive value.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction("Deposit $" + amount);
            System.out.println("Deposit successful. New Balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recordTransaction("Withdraw $" + amount);
            System.out.println("Withdrawal successful. New Balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        recordTransaction("Interest Applied: $" + interest);
        System.out.println(
                "Interest applied. New Balance: $" + balance + " (Interest Rate: " + interestRate + "% annual)");
    }

    public void viewTransactionHistory() {
        System.out.println("--- Transaction History ---");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println("- " + transactionHistory[i]);
        }
    }

    private void recordTransaction(String transaction) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount++] = transaction;
        }
    }

    public void displayAccountDetails() {
        System.out.println("--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

public class secureBankSystemDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.println("Welcome to the Secure Banking System");

        int choice = 0;
        while (choice != 7) {
            System.out.println("1. Create Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Apply Interest");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number (10 digits): ");
                    String accountNumberInput = scan.next();
                    scan.nextLine(); // Consume newline
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderInput = scan.nextLine();
                    System.out.print("Enter Initial Deposit: ");
                    double depositInput = scan.nextDouble();
                    accounts.add(new BankAccount(accountNumberInput, accountHolderInput, depositInput, 5.0));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    for (BankAccount account : accounts) {
                        account.displayAccountDetails();
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String accNumDeposit = scan.next();
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber().equals(accNumDeposit)) {
                            System.out.print("Enter deposit amount: ");
                            double amount = scan.nextDouble();
                            account.deposit(amount);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String accNumWithdraw = scan.next();
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber().equals(accNumWithdraw)) {
                            System.out.print("Enter withdrawal amount: ");
                            double amount = scan.nextDouble();
                            account.withdraw(amount);
                            break;
                        }
                    }
                    break;

                case 5:
                    for (BankAccount account : accounts) {
                        account.applyInterest();
                    }
                    break;

                case 6:
                    for (BankAccount account : accounts) {
                        account.viewTransactionHistory();
                    }
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scan.close();
    }
}
