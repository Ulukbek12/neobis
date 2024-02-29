package week1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println(number); // Print the read number

            int hundreds = number / 100;
            number %= 100;

            int fifties = number / 50;
            number %= 50;

            int twenties = number / 20;
            number %= 20;

            int tens = number / 10;
            number %= 10;

            int fives = number / 5;
            number %= 5;

            int twos = number / 2;
            number %= 2;

            int ones = number;

            System.out.printf("%d nota(s) de R$ 100,00\n" +
                    "%d nota(s) de R$ 50,00\n" +
                    "%d nota(s) de R$ 20,00\n" +
                    "%d nota(s) de R$ 10,00\n" +
                    "%d nota(s) de R$ 5,00\n" +
                    "%d nota(s) de R$ 2,00\n" +
                    "%d nota(s) de R$ 1,00\n", hundreds, fifties, twenties, tens, fives, twos, ones);

        } catch (InputMismatchException e) {
            System.out.println("This is not a valid integer ");
        }
    }
}
