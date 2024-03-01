package week1;

public class Sequence {
    public static void main(String[] args) {
        for (float i = 0; i <= 2.01; i += 0.2) {
            for (double j = 1; j <= 3; j++) {
                if (i == 0 || i >= 2 || i == 1) {
                    System.out.printf("I=%.0f J=%.0f%n", i, j);
                } else {
                    System.out.printf("I=%.1f J=%.1f%n", i, j);
                }
            }
        }
    }
}



