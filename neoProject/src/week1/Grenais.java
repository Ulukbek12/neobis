package week1;
import java.util.Scanner;
public class Grenais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grenais = 0;
        int interWins = 0;
        int gremioWins = 0;
        int draws = 0;
        int option;
        do{
            int interScore = scanner.nextInt();
            int gremioScore = scanner.nextInt();
            option = scanner.nextInt();
            if(interScore > gremioScore){
                interWins++;
            }
            else if(interScore < gremioScore){
                gremioWins++;
            }
            else{
                draws++;
            }
            grenais++;
        }while(option != 2);
        for(int i = 0; i < grenais; i++){
            System.out.println("Novo grenal (1-sim 2-nao)");
        }
        System.out.println(grenais + " grenais");
        System.out.println("Inter:" + interWins);
        System.out.println("Gremio:" + gremioWins);
        System.out.println("Empates:" + draws);
        if(interWins > gremioWins){
            System.out.println("Inter venceu mais");
        }
        else if(interWins < gremioWins){
            System.out.println("Gremio venceu mais");
        }
        else{
            System.out.println("Draw");
        }
    }
}


