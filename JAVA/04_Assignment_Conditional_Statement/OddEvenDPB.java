import java.util.Scanner;
public class OddEvenDPB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number:  ");
        int num = scan.nextInt();
        scan.close();
        if(num%2 == 0){
            System.out.println(num + " is an even number");
        }else{
            System.out.println(num + " is an odd number");
        }

    }
}
