import java.util.Scanner;
public class BMICalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your weight (kg):");
        float weight = scan.nextFloat();
        System.out.println("Enter your height (m):");
        float height = scan.nextFloat();

        
        System.out.println("=== BMI Report ===  ");
        // Formula
        Float BMI = weight / (height * height);
        
        System.out.println("Your BMI: " + BMI);
        // Conditional Statement
        if(BMI < 18.5 ){
            System.out.println("Health Status: Underweight");
        }else if(BMI >= 18.5 && BMI < 24.9){
            System.out.println("Health Status: Normal");
        }else if(BMI >= 25 && BMI < 29.9){
            System.out.println("Health Status: Overweight");
        }else if(BMI >= 30){
            System.out.println("Health Status: Obese");
        }
    }
}