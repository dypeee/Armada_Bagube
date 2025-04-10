import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your full name:");
        String name = scan.nextLine();

        String upperCaseName = name.toUpperCase();
        System.out.println("Uppercase Name:" + upperCaseName);

        String totalChar = name.replace(" ", "");
        System.out.println("Total Characters (excluding spaces):" + totalChar.length());

        String trimmed = name.trim();
        int spaceIndex = trimmed.indexOf(' ');
        char firstInitial = trimmed.charAt(0);
        char lastInitial = trimmed.charAt(spaceIndex + 1);
        System.out.println("Initials: " + Character.toUpperCase(firstInitial) + "." + Character.toUpperCase(lastInitial) + ".");
        
        
    }
}
