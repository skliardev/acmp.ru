import java.util.Scanner;

public class task317 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int X = sc.nextInt(), Y = sc.nextInt(), Z = sc.nextInt(), W = sc.nextInt();
            int XN = W/X, YN = W/Y, ZN = W/Z;

            int sum = 0, counter  = 0;
            for (int k = 0; k <= ZN; k++){
                for (int j = 0; j <= YN; j++)
                    for (int i = 0; i <= XN; i++){
                        sum = i*X + j*Y + k*Z;
                        if(sum > W) break;
                        else if(sum == W) counter++;
                    }
            }
            System.out.print(counter);
    }
}
