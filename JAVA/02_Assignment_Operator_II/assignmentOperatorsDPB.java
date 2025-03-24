public class assignmentOperatorsDPB {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("x += 5: " + (x += 5));
        System.out.println("x -= 3: " + (x -= 3));
        System.out.println("x *= 2: " + (x *= 2));
        System.out.println("x /= 4: " + (x /= 4));
        System.out.println("x %= 3: " + (x %= 3));
        
        double price = 100;
        price *= 0.8;
        price *= 1.1;
        System.out.println("Final Price: " + price);
    }
}
