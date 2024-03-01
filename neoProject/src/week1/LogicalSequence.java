package week1;
import java.util.Scanner;

public class LogicalSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if(x > 1 && x < 20 && y > x && y < 100000){
            int count = 0;
            for(int i = 1; i <= y; i++){
                System.out.print(i);
                count++;
                if(count < x){
                    System.out.print(" ");
                }
                else{
                    System.out.println();
                    count = 0;
                }
            }
        }
    }
}
