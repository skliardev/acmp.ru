import java.util.Scanner;

public class task654 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            long counter = 0;
            int prev = scanner.nextInt();
            int nMax = prev;
            for(int i = 1; i < n; ++i) {
                int cur = scanner.nextInt();
                nMax = Math.max(nMax, cur);
                if(cur > prev)
                    counter += cur - prev;
                prev = cur;
            }
            counter += nMax - prev;
            System.out.print(counter);
    }
}
