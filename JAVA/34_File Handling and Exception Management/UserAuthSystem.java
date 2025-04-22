import java.io.*;
import java.util.Scanner;

public class UserAuthSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        String username;
        String password;

        while (choice != 3) {
            System.out.println("-----------------------------");
            System.out.println("1 Register");
            System.out.println("2 Login");
            System.out.println("3 Exit");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.print("Username: ");
                    username = scan.nextLine();
                    System.out.print("Password: ");
                    password = scan.nextLine();

                    if (username.matches("[a-zA-Z0-9]+") && password.matches("[a-zA-Z0-9]+")) {
                        boolean userExists = false;

                        try {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader("records.txt"));
                            String line;

                            // chheck if its existing
                            while ((line = bufferedReader.readLine()) != null) {
                                String[] accounts = line.split(",");
                                if (accounts.length == 2 && accounts[0].equals(username)) {
                                    userExists = true;
                                    break;
                                }
                            }
                            bufferedReader.close();

                            if (userExists) {
                                System.out.println("Username already exists.");
                            } else {
                                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("records.txt", true));
                                bufferedWriter.write(username + "," + password);
                                bufferedWriter.newLine();
                                bufferedWriter.close();
                                System.out.println("Registration successful!");
                            }

                        } catch (IOException e) {
                            System.out.println("Something went wrong.");
                        }
                    } else {
                        System.out.println("Username and password must be alphanumeric only.");
                    }
                    break;

                case 2:
                    System.out.println("-----------------------------");
                    System.out.print("Username: ");
                    username = scan.nextLine();
                    System.out.print("Password: ");
                    password = scan.nextLine();

                    boolean loginSuccessful = false;
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader("records.txt"));
                        String line;

                        while ((line = bufferedReader.readLine()) != null) {
                            String[] accounts = line.split(",");
                            if (accounts.length == 2) {
                                String storedUsername = accounts[0];
                                String storedPassword = accounts[1];

                                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                                    loginSuccessful = true;
                                    break;
                                }
                            }
                        }
                        bufferedReader.close();

                        if (loginSuccessful) {
                            System.out.println("Successfully logged in");
                        } else {
                            System.out.println("Incorrect username or password");
                        }
                    } catch (IOException e) {
                        System.out.println("Something went wrong.");
                    }

                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }

        scan.close();
    }
}
