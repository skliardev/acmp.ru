import java.util.Scanner;

public class task53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int max = Math.max(m, n), min = Math.min(m, n);
        int black = n*m, red = 0, green = 0, blue = 0;

        for (int j = 1; j <= max; ++j) {
            int tAdd = 2;
            for (int i = 1; i <= j && i <= min; ++i) {
                int tValue = i * j;

                if(j > min || i == j) tAdd = 1;

                if(tValue % 5 == 0) blue += tAdd;
                else if(tValue % 3 == 0) green += tAdd;
                else if(tValue % 2 == 0) red += tAdd;
                else continue;
                black -= tAdd;
            }
        }
        System.out.printf("RED : %d\nGREEN : %d\nBLUE : %d\nBLACK : %d", red, green, blue, black);
    }
}
