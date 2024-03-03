package week1;

import java.util.Scanner;

public class BanknotesAndCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] notes = {100, 50, 20, 10, 5, 2};
        double[] coins = {1, 0.5, 0.25, 0.10, 0.05, 0.01};
        double money = scanner.nextDouble();//576,73
        int moneyInt = (int) (money * 100);//57673
        System.out.println("NOTAS:");
        for (int note : notes) {
            int localNote = note * 100;
            int result = moneyInt / localNote;
            moneyInt %= localNote;
            System.out.printf("%d nota(s) de R$ %.2f\n", result,(double)note);
        }
        System.out.println("MOEDAS:");
        for (double coin : coins) {
            int localCoin = (int) (coin * 100);
            int result = moneyInt / localCoin;
            moneyInt %= localCoin;
            System.out.printf("%d moeda(s) de R$ %.2f\n", result, coin);
        }
    }
}
