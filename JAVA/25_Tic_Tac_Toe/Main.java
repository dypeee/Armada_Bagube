import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum, secondNum;
        boolean exit = true;

        System.out.println("Tic-Tac-Toe Game");
        String[][] matrix = {
                { " ", "1", "2", "3" },
                { "1", "_", "_", "_" },
                { "2", "_", "_", "_" },
                { "3", "_", "_", "_" }
        };

        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        while (exit) {
            // Player X
            do {
                System.out.println("Player X, enter row and column:");
                firstNum = scan.nextInt();
                secondNum = scan.nextInt();
            } while (!matrix[firstNum][secondNum].equals("_"));
            
            matrix[firstNum][secondNum] = "X";
            for (String[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
            
            //Player X win
            boolean win = false;
            for (int i = 1; i <= 3; i++) {
                if (matrix[i][1].equals("X") && matrix[i][2].equals("X") && matrix[i][3].equals("X")) win = true; // Rows
            }
            for (int j = 1; j <= 3; j++) {
                if (matrix[1][j].equals("X") && matrix[2][j].equals("X") && matrix[3][j].equals("X")) win = true; // Columns
            }
            if (matrix[1][1].equals("X") && matrix[2][2].equals("X") && matrix[3][3].equals("X")) win = true; // Main diagonal
            if (matrix[1][3].equals("X") && matrix[2][2].equals("X") && matrix[3][1].equals("X")) win = true; // Other diagonal

            if (win) {
                System.out.println("Player X wins!");
                break;
            }

            // Player O
            do {
                System.out.println("Player O, enter row and column:");
                firstNum = scan.nextInt();
                secondNum = scan.nextInt();
            } while (!matrix[firstNum][secondNum].equals("_"));
            
            matrix[firstNum][secondNum] = "O";
            for (String[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }
            
            //Player O WIn
            win = false;
            for (int i = 1; i <= 3; i++) {
                if (matrix[i][1].equals("O") && matrix[i][2].equals("O") && matrix[i][3].equals("O")) win = true;
            }
            for (int j = 1; j <= 3; j++) {
                if (matrix[1][j].equals("O") && matrix[2][j].equals("O") && matrix[3][j].equals("O")) win = true;
            }
            if (matrix[1][1].equals("O") && matrix[2][2].equals("O") && matrix[3][3].equals("O")) win = true;
            if (matrix[1][3].equals("O") && matrix[2][2].equals("O") && matrix[3][1].equals("O")) win = true;

            if (win) {
                System.out.println("Player O wins!");
                break;
            }
        }

        scan.close();
    }
}
