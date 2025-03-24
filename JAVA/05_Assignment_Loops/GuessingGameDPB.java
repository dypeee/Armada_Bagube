import java.util.Scanner;
import java.util.Random;
public class GuessingGameDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int randomNum = random.nextInt(50)+1;
        boolean exit = true;
        int attempt = 0;
        while (exit) {
            System.out.print("Guess a number between 1 and 50: ");
            int guess = scan.nextInt();
            if(guess > randomNum){
                System.out.println("Too High!");

            }else if(guess < randomNum){
                System.out.println("Too Low!");
            }else{
                exit = false;
            }
            attempt++;
        }
        System.out.println("Correct! You guessed it in "+ attempt +" attempts. ");
    }
}
