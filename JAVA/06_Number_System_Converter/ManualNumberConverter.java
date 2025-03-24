import java.util.Scanner;

public class ManualNumberConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a decimal number: ");
        int number = scanner.nextInt();
        
        // Convert to Binary
        String binary = "";
        int temp = number;
        while (temp > 0) {
            binary = (temp % 2) + binary;
            temp /= 2;
        }
        if (binary.isEmpty()) binary = "0";
        
        // Convert to Octal
        String octal = "";
        temp = number;
        while (temp > 0) {
            octal = (temp % 8) + octal;
            temp /= 8;
        }
        if (octal.isEmpty()) octal = "0";
        
        
        // Convert to Hexadecimal
        String hexDigits = "0123456789ABCDEF";
        String hexadecimal = "";
        temp = number;
        while (temp > 0) {
            hexadecimal = hexDigits.charAt(temp % 16) + hexadecimal;
            temp /= 16;
        }
        if (hexadecimal.isEmpty()) hexadecimal = "0";
        
        System.out.println("\n=== Number System Conversions ===");
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hexadecimal);
        
        scanner.close();
    }
}
