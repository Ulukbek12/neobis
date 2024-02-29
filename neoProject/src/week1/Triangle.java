package week1;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        //7,5,7
        //6,6,10
        //6,6,6
        //5,7,2
        //6,8,10
        double A = Math.max(a,Math.max(b,c));
            if((A == a) ||(A == b) || (A == c)) {
                double B = b;
                double C = c;
                if(A == b){
                    B = a;
                }
                if(A == c){
                    C = a;
                }
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
}

