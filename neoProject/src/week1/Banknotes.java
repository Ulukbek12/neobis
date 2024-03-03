package week1;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class Banknotes {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println(number);
            int[] banknotes = new int[]{100,50,20,10,5,2,1};
            ///576
            for(int note : banknotes){
               int result = number / note; // 5
                number %= note; // 76
                System.out.printf(Locale.ITALY,"%d nota(s) de R$ %.2f\n",result,(double)note);
            }
        } catch (InputMismatchException e) {
            System.out.println("This is not a valid integer ");
        }
    }
}
