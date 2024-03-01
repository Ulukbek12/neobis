package week1;

import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        for(int i = 0; i < lines; i++){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            double A_growRate = scanner.nextDouble();
            double B_growRate = scanner.nextDouble();
            int attempts = 0;
            //100 150 1,0 0
            while(A <= B){
                A = A + (int)(A * A_growRate/100);
                B = B + (int)(B* B_growRate/100);
                attempts++;
                if (attempts > 100) {
                    System.out.println("Mais de 1 seculo.");
                    break;
                }
            }
            if (attempts <= 100) {
                System.out.println(attempts + " anos.");
            }
        }
    }
}
