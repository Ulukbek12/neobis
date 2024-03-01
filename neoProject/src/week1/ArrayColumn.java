package week1;

import java.util.Scanner;

public class ArrayColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();
        String type = scanner.next();
        int rows = 12;
        double[][] arr = new double[rows][12];
        double sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 12; j++) {
                arr[i][j] = scanner.nextDouble();
            }
        }
        for (int i = 0; i < rows; i++) {
            sum += arr[i][column];
        }

        if (type.equalsIgnoreCase("s")) {
            System.out.printf("%.1f%n", sum);
        } else if (type.equalsIgnoreCase("m")) {
            System.out.printf("%.1f%n", sum / rows);
        }
    }
}


