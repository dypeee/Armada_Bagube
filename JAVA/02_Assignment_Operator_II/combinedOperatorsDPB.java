public class combinedOperatorsDPB {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        if (a >= 0 && b >= 0) {
            a += b;
            b = a * 2;
        }
        System.out.println("The Final Value of a is " + a);
        System.out.println("The Final Value of b is " + b);
    }
}
