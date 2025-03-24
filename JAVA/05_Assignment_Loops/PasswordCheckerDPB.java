import java.util.Scanner;

public class PasswordCheckerDPB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String currentPassword = "abc123";
        boolean login = true;
        do {
            System.out.print("Enter password: ");
            String password = scan.nextLine();
            if(currentPassword.equals(password)){
                System.out.println("Access granted!");
                login = false;
            }else{
                System.out.println("Incorrect password. Try again.  ");
            }
        } while (login);
        
    }
}