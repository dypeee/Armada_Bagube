import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a paragraph: ");
        String paragraph = scan.nextLine();

        String trimmed = paragraph.trim();
        String singleSpaced = trimmed.replaceAll("\\s+", " ");
        String[] words = singleSpaced.split(" ");
        int wordCount = words.length;

        System.out.println("Word Count: " + wordCount);

        String modified = singleSpaced.replace("Java", "Python");

        System.out.println("Modified Paragraph: "+modified);

    }
}
