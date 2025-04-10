import java.util.Scanner;

interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCard implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPal implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose payment method (1: Credit Card, 2: PayPal): ");
        int choice = scanner.nextInt();

        PaymentMethod paymentMethod;

        if (choice == 1) {
            paymentMethod = new CreditCard();
        } else if (choice == 2) {
            paymentMethod = new PayPal();
        } else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();

        paymentMethod.processPayment(amount);

        scanner.close();
    }
}
