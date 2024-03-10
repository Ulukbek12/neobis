package week1;
import java.util.Scanner;
public class WeightedAverages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        scanner.nextLine();
        while(lines > 0) {
            for (int j = 0; j < 3; j++) {
                numbers[j] = scanner.nextDouble();
            }
            double weightedSum = (num1 * 2 + num2 * 3 + num3 * 5);
            double weightedAverage = weightedSum / 10.0;
            System.out.printf("%.1f%n", weightedAverage);
            lines--;
        }
    }
}


