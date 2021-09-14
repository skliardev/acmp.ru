import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class task_18 {
    public static void main(String[] args) {
        Path inf = Paths.get("src\\INPUT.TXT");
        Path ouf = Paths.get("src\\OUTPUT.TXT");

        try(Scanner scanner = new Scanner(new InputStreamReader(Files.newInputStream(inf), StandardCharsets.UTF_8));
            Writer writer = new OutputStreamWriter(Files.newOutputStream(ouf), StandardCharsets.UTF_8)) {
            int value = scanner.nextInt();
            BigInteger result = BigInteger.ONE;
            int index = 1;
            while (index < value) {
                ++index;
                result = result.multiply(BigInteger.valueOf(index));
            }
            writer.write(result.toString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
