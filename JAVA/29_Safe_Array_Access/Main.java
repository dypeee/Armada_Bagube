import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an index (0-4): ");
        try {
            int index = scanner.nextInt();
            System.out.println("Element at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index. Please enter a number between 0 and 4.");
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
