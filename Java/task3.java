import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Path inf = Paths.get("src\\INPUT.TXT");
        Path ouf = Paths.get("src\\OUTPUT.TXT");

        try(Scanner scanner = new Scanner(new InputStreamReader(Files.newInputStream(inf), StandardCharsets.UTF_8));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(Files.newOutputStream(ouf), StandardCharsets.UTF_8))) {
            int value = scanner.nextInt();
            if (value % 10 != 5) throw new IllegalArgumentException("Число должно оканчиваться на 5");
            if (value == 5) writer.write("25");
            else {
                value /= 10;
                value = value*(value + 1);
                writer.printf("%d25", value);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
