
public class Main {
    public static void main(String[] args) {
        int[] grades = {5, 10, 15, 20, 25};
        int sum = 0;
        for(int grade:grades){
            sum += grade;
        }
        System.out.println("Sum of elements:" + sum);
    }
}
