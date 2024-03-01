package week1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BanknotesAndCoins {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            double number = scanner.nextDouble() * 100; // Convert to cents 576,73 --> 57673
            int cents = (int) number;

            int hundreds = cents / 10000;//5
            cents %= 10000;
            int fifties = cents / 5000;//1
            cents %= 5000;
            int twenties = cents / 2000;//1
            cents %= 2000;
            int tens = cents / 1000;//0
            cents %= 1000;
            int fives = cents / 500;//1
            cents %= 500;
            int twos = cents / 200;//0
            cents %= 200;

            int one = cents / 100;//1
            cents %= 100;
            int half = cents / 50;//1
            cents %= 50;
            int oneFourth = cents / 25;//0
            cents %= 25;
            int tenCent = cents / 10;//2
            cents %= 10;
            int tenCentAndHalf = cents / 5;//0
            cents %= 5;
            int oneCent = cents;//3

            System.out.printf("NOTAS:%n" +
                            "%d nota(s) de R$ 100.00%n" +
                            "%d nota(s) de R$ 50.00%n" +
                            "%d nota(s) de R$ 20.00%n" +
                            "%d nota(s) de R$ 10.00%n" +
                            "%d nota(s) de R$ 5.00%n" +
                            "%d nota(s) de R$ 2.00%n" +
                            "MOEDAS:%n" +
                            "%d moeda(s) de R$ 1.00%n" +
                            "%d moeda(s) de R$ 0.50%n" +
                            "%d moeda(s) de R$ 0.25%n" +
                            "%d moeda(s) de R$ 0.10%n" +
                            "%d moeda(s) de R$ 0.05%n" +
                            "%d moeda(s) de R$ 0.01%n",
                    hundreds, fifties, twenties, tens, fives, twos,
                    one, half, oneFourth, tenCent, tenCentAndHalf, oneCent);
        } catch (InputMismatchException e) {
            System.out.println("This is not a valid integer ");
        }
    }
}
