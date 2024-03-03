package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] nums = {scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble()};
        Arrays.sort(nums);
        double A = nums[2];
        double B = nums[1];
        double C = nums[0];
                if (A >= B + C) {
                    System.out.println("NAO FORMA TRIANGULO");
                }
                if(!(A >= B + C)) {
                    if (Math.pow(A, 2) == Math.pow(B, 2) + Math.pow(C, 2)) {
                        System.out.println("TRIANGULO RETANGULO");
                    }
                    if (Math.pow(A, 2) > Math.pow(B, 2) + Math.pow(C, 2)) {
                        System.out.println("TRIANGULO OBTUSANGULO");
                    }
                    if (Math.pow(A, 2) < Math.pow(B, 2) + Math.pow(C, 2)) {
                        System.out.println("TRIANGULO ACUTANGULO");
                    }
                    if ((A == B) && (B == C) && (A == C)) {
                        System.out.println("TRIANGULO EQUILATERO");
                    } else if ((A == B) || (B == C) || (A == C)) {
                        System.out.println("TRIANGULO ISOSCELES");
                    }
                }
    }
}

