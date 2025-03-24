import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your choice (R, P, S): ");
        String choice = scan.nextLine();
       
         // Generate random choicces
         String[] choices = {"R", "P", "S"};
         String computer = choices[random.nextInt(3)];
         System.out.println("Computer chose: " + computer);
       

         switch (choice + computer) {
            case "RS":
            case "PR":
            case "SP":
                System.out.println("You win!");
                break;
            case "RP":
            case "PS":
            case "SR":
                System.out.println("You lose!");
                break;
            default:
                System.out.println("It's a tie!");
                break;
        }

    }
}
