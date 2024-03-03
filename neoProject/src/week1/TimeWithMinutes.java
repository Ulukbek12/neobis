package week1;

import java.util.Scanner;

public class TimeWithMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initHour = scanner.nextInt();
        int initMinutes = scanner.nextInt();
        int finalHour = scanner.nextInt();
        int finalMinutes = scanner.nextInt();
        int startTimeInMinutes = initHour * 60 + initMinutes;
        int endTimeInMinutes = finalHour * 60 + finalMinutes;
        //7 7 6 6
        int durationInMinutes = (endTimeInMinutes - startTimeInMinutes + 24 * 60) % 24 * 60;
        if (durationInMinutes == 0) {
            durationInMinutes = 24 * 60;
        }
        int hours = durationInMinutes / 60;
        int minutes = durationInMinutes % 60;

        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", hours, minutes);
    }
}

