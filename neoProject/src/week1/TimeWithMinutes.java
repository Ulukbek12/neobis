package week1;

import java.util.Scanner;

public class TimeWithMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initHour = scanner.nextInt();
        int initMinutes = scanner.nextInt();
        int finalHour = scanner.nextInt();
        int finalMinutes = scanner.nextInt();

        if((finalHour > initHour) && (finalMinutes > initMinutes)){
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)",finalHour - initHour,
                    finalMinutes - initMinutes);
        }
        else if((finalHour > initHour) && (finalMinutes < initMinutes)){
            int localMinutes = finalMinutes + ((finalHour - initHour) * 60);//69
            int localMinutes1 = localMinutes - initMinutes;
            int localHours = 0;
            if(localMinutes1 >= 60){
                 localHours = localMinutes / 60;
                localMinutes = localHours % 60;
            }
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)",localHours,
                    localMinutes - initMinutes);
        }
        //9 10 8 12
        else if((finalHour < initHour) && (finalMinutes > initMinutes)){
            int localHours = finalHour - initHour + 24;
            int localMinutes = finalMinutes - initMinutes;
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)",localHours,
                    localMinutes);
        }
        // 9 12 8 10
        // 9 12 7 70
        else if((finalHour < initHour) && (finalMinutes < initMinutes)){//22:58
            int localHours = (finalHour - 1) - initHour + 24; //22
            int localMinutes =  (finalMinutes + 60) - initMinutes;
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)",localHours,
                    localMinutes);
        }
        //7 8 7 10
        else if((finalHour == initHour) && (finalMinutes > initMinutes)){
            int localHours = 24;
            int localMinutes = finalMinutes - initMinutes;

            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)",
                    localHours,localMinutes);
        }
        else if((finalHour == initHour) && (finalMinutes == initMinutes)){
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)",
                    24,0);
        }
        //7 10 7 8
        //7 10 6 68
        else if((finalHour == initHour) && (finalMinutes < initMinutes)){
            finalMinutes = finalMinutes + 60;
            finalHour -= 1;
            int localHours = finalHour - initHour + 24;
            int localMinutes = finalMinutes - initMinutes;
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)",localHours,
                    localMinutes);
        }
    }
}
