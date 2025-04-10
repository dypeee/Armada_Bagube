import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> inventory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Product Name");
            System.out.println("3. Find Product by ID");
            System.out.println("4. Remove Product");
            System.out.println("5. Display Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                int productID = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Product Name: ");
                String productName = scanner.nextLine();

                inventory.put(productID, productName);
                System.out.println("Product added!");

            } else if (choice == 2) {
                System.out.print("Enter Product ID: ");
                int productID = scanner.nextInt();
                scanner.nextLine();

                if (inventory.containsKey(productID)) {
                    System.out.print("Enter new Product Name: ");
                    String newProductName = scanner.nextLine();
                    inventory.put(productID, newProductName);
                    System.out.println("Product updated!");
                } else {
                    System.out.println("Product not found!");
                }

            } else if (choice == 3) {
                System.out.print("Enter Product ID: ");
                int productID = scanner.nextInt();
                scanner.nextLine();

                if (inventory.containsKey(productID)) {
                    System.out.println("Product Found: " + inventory.get(productID));
                } else {
                    System.out.println("Product not found!");
                }

            } else if (choice == 4) {
                System.out.print("Enter Product ID to remove: ");
                int productID = scanner.nextInt();
                scanner.nextLine();

                if (inventory.containsKey(productID)) {
                    inventory.remove(productID);
                    System.out.println("Product removed!");
                } else {
                    System.out.println("Product not found!");
                }

            } else if (choice == 5) {
                System.out.println("\nCurrent Inventory:");
                for (Integer productID : inventory.keySet()) {
                    System.out.println(productID + " - " + inventory.get(productID));
                }

            } else if (choice == 6) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
