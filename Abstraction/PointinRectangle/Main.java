package PointinRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int xBottomLeft = coordinates[0];
        int yBottomLeft = coordinates[1];

        Point bottomLeft = new Point(xBottomLeft, yBottomLeft);

        int xTopRight = coordinates[2];
        int yTopRight = coordinates[3];

        Point topRight = new Point(xTopRight, yTopRight);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count ; i++) {
            int[] pointCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            Point curr = new Point(pointCoordinates[0], pointCoordinates[1]);
            System.out.println(rectangle.contains(curr));
        }


    }


}
