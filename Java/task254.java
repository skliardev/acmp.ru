import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class task_254 {
    public static void main(String[] args) {
        Path inf = Paths.get("src\\INPUT.TXT");
        Path ouf = Paths.get("src\\OUTPUT.TXT");

        try (Scanner scanner = new Scanner(new InputStreamReader(Files.newInputStream(inf), StandardCharsets.UTF_8));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(Files.newOutputStream(ouf), StandardCharsets.UTF_8))) {
            scanner.useDelimiter("\\n|\\r\\n|\\s");

            int n = scanner.nextInt();  // 1<= n <= 5000 regions
            int[] arrOld = new int[n];  // Current rulers
            int[] arrNew = new int[n];  // Next rulers

            // Get arrays покровителей
            for (int i = 0; i < n; ++i) {
                int value = scanner.nextInt();
                arrOld[i] = value;
                arrNew[i] = value;
            }

            int m = scanner.nextInt();  // 1<= m <= 200 orders
            for (int i = 0; i < m; ++i) {
                int valueOld = scanner.nextInt();
                int valueNew = scanner.nextInt();
                for (int j = 0; j < n; ++j)
                    if(arrOld[j] == valueOld) arrNew[j] = valueNew;
            }

            for (int i = 0; i < n; ++i)
                writer.printf("%d ", arrNew[i]);
            writer.flush();

        } catch (IOException e) {
            System.out.println("Файл отсутствует или поврежден");
            e.printStackTrace();
        } ;
    }
}
