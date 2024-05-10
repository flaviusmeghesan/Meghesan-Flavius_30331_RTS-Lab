package Laboratory1.LabSheet1.Exercise3;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] randomNumbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            randomNumbers[i] = random.nextInt(100);
        }

        System.out.println("random array");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        Arrays.sort(randomNumbers);

        System.out.println("sorted array");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
    }
}
