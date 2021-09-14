import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class task46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print((new BigDecimal("2.7182818284590452353602875")).setScale(scanner.nextInt(), RoundingMode.HALF_UP));
    }
}
