package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static long sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] heroCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];
            while (evilRow >= 0 && evilCol >= 0) {
                if (evilRow >= 0 && evilRow < matrix.length && evilCol >= 0 && evilCol < matrix[0].length) {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }

        int heroRow = heroCoordinates[0];
        int heroCol = heroCoordinates[1];
            while (heroRow >= 0 && heroCol < matrix[1].length) {
                if (heroRow >= 0 && heroRow < matrix.length && heroCol >= 0 && heroCol < matrix[0].length) {
                    sum += matrix[heroRow][heroCol];
                }

                heroCol++;
                heroRow--;
            }


            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static void moveCordinates(int[][] matrix, int row, int col, String type) {
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[0].length) {

                if (type.equals("evil")) {
                    matrix[row][col] = 0;
                } else if (type.equals("hero")) {
                    sum += matrix[row][col];
                }
            }
            row--;
            col--;
        }
    }
}


