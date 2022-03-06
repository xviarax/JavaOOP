package ClassBox;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double length = Double.parseDouble(scanner.nextLine());
    double width = Double.parseDouble(scanner.nextLine());
    double height = Double.parseDouble(scanner.nextLine());

    Box box = new Box(length,width,height);
        System.out.printf(Locale.US,"Surface Area - %.2f%n", box.calculateSurfaceArea());
        System.out.printf(Locale.US,"Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
        System.out.printf(Locale.US,"Volume - %.2f", box.calculateVolume());


    }
}
