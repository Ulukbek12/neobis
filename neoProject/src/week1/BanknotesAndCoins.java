package week1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BanknotesAndCoins {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            double number = scanner.nextDouble();
            //banknotes
            double hundreds = number / 100;
            number %= 100;
            double fifties = number / 50;
            number %= 50;
            double twenties = number / 20;
            number %= 20;
            double tens = number / 10;
            number %= 10;
            double fives = number / 5;
            number %= 5;
            double twos = number / 2;
            number %= 2;//1.73
            //coins
            double one = number;
            number %= 1;
            double half = number/0.5;
            number %=0.5;
            double oneFourth = number/0.25;
            number %=0.25;
            double tenCent = number/0.1;
            number %=0.1;
            double tenCentAndHalf = number/0.05;
            number %=0.05;
            double oneCent = number/0.01;
            System.out.printf("NOTAS:%n" +
                    "%d nota(s) de R$ 100.00\n" +
                    "%d nota(s) de R$ 50.00\n" +
                    "%d nota(s) de R$ 20.00\n" +
                    "%d nota(s) de R$ 10.00\n" +
                    "%d nota(s) de R$ 5.00\n" +
                    "%d nota(s) de R$ 2.00\n" +
                    "MOEDAS:%n" +
                    "%d moeda(s) de R$ 1.00\n" +
                    "%d moeda(s) de R$ 0.50\n" +
                    "%d moeda(s) de R$ 0.25\n" +
                     "%d moeda(s) de R$ 0.10\n" +
                     "%d moeda(s) de R$ 0.05\n" +
                     "%d moeda(s) de R$ 0.01",(int)hundreds, (int)fifties, (int)twenties, (int)tens,
                    (int)fives, (int)twos,(int)one,(int) half,(int) oneFourth,(int)tenCent,
                    (int) tenCentAndHalf,(int) oneCent);
        } catch (InputMismatchException e) {
            System.out.println("This is not a valid integer ");
        }
    }
}
