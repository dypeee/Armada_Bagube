import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int iterations = 100000;

        // Strring
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "Java";
        }
        long stringTime = System.nanoTime() - startTime;
        System.out.println("Appending 100,000 times using String took: " + (stringTime / 1_000_000) + "ms");

        //StringBuilder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("Java");
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        System.out.println("Appending 100,000 times using StringBuilder took: " + (stringBuilderTime / 1_000_000) + "ms");

        //StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("Java");
        }
        long stringBufferTime = System.nanoTime() - startTime;
        System.out.println("Appending 100,000 times using StringBuffer took: " + (stringBufferTime / 1_000_000) + "ms");

        String fastest = (stringTime < stringBuilderTime && stringTime < stringBufferTime) ? "String": (stringBuilderTime < stringBufferTime) ? "StringBuilder" : "StringBuffer";
        System.out.println("Fastest method: " + fastest);
    }
}
