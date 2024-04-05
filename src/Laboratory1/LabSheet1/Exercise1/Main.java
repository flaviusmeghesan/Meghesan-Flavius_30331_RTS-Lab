package Laboratory1.LabSheet1.Exercise1;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter real part for first nr");
        int real1 = scanner.nextInt();

        System.out.println("enter img part for first nr");
        int img1 = scanner.nextInt();

        System.out.println("enter real part for second nr");
        int real2 = scanner.nextInt();

        System.out.println("enter img part for second nr");
        int img2 = scanner.nextInt();

        ComplexNumber complex1 = new ComplexNumber(real1, img1);
        ComplexNumber complex2 = new ComplexNumber(real2, img2);

        System.out.println("1 = +");
        System.out.println("2 = -");
        System.out.println("3 = *");
        System.out.print("choose (1 or 2 or 3)");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayResult("add", complex1.add(complex2));
                break;
            case 2:
                displayResult("sub", complex1.subtract(complex2));
                break;
            case 3:
                displayResult("mul", complex1.multiply(complex2));
                break;
            default:
                System.out.println("invalid choice; choose 1, 2, or 3.");
        }

        scanner.close();
    }

    private static void displayResult(String operation, ComplexNumber result) {
        System.out.println(operation + " result: " + result);
    }
}
