public class logicalOperatorsDPB {
    public static void main(String[] args) {
        boolean a = true, b = false;

        System.out.println("a && b: " + (a && b)); 
        System.out.println("a || b: " + (a || b));
        System.out.println("!a: " + (!a)); 
        System.out.println("!b: " + (!b)); 

        int creditScore = 750;
        double annualIncome = 55000;

        if (creditScore > 700 && annualIncome > 50000) {
            System.out.println("The person is eligible for a loan.");
        } else {
            System.out.println("The person is NOT eligible for a loan.");
        }
    }
}
