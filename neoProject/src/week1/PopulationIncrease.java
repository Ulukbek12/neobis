package week1;

import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempt = 0;
        int lines = scanner.nextInt();
        if(lines >= 1 && lines <=3000) {
            do {
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                double A_growRate = scanner.nextDouble();
                double B_growRate = scanner.nextDouble();
                if((A >= 100 && A < 1000000 && A < B) && ((A_growRate >= 0.1 &&
                    A_growRate <= 10.0) && (B_growRate >= 0.0 && B_growRate <= 10.0)
                     && (A_growRate > B_growRate))){
                    //100 150 1,0 0 --> 51 years
                    while(A < B){
                        A += (int) (A * A_growRate);
                        attempt++;
                        if(A == B){
                            break;
                        }
                    }
                }
                    lines--;
            } while (lines > 0);
        }
        System.out.println(attempt);
    }
}
