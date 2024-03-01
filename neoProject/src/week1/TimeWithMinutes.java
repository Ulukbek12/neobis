package week1;

import java.util.Scanner;

public class TimeWithMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initHour = scanner.nextInt();
        int initMinutes = scanner.nextInt();
        int finalHour = scanner.nextInt();
        int finalMinutes = scanner.nextInt();

        // Convert initial and final times to minutes from midnight
        int startTimeInMinutes = initHour * 60 + initMinutes;
        int endTimeInMinutes = finalHour * 60 + finalMinutes;

        // Calculate the duration of the game in minutes
        int durationInMinutes = (endTimeInMinutes - startTimeInMinutes + 24 * 60) % (24 * 60);

        // Handle the case where the start and end times are the same
        if (durationInMinutes == 0) {
            durationInMinutes = 24 * 60; // Set duration to 24 hours
        }

        // Calculate hours and minutes from duration
        int hours = durationInMinutes / 60;
        int minutes = durationInMinutes % 60;

        // Print the result
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", hours, minutes);
    }
}

