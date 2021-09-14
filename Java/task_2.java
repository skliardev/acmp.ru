import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        final int MAX_VALUE = 10000;
        Path ifile = Paths.get("INPUT.TXT");
        Path ofile = Paths.get("OUTPUT.TXT");

        try(Reader reader = new InputStreamReader(Files.newInputStream(ifile), StandardCharsets.UTF_8);
            Writer writer = new OutputStreamWriter(Files.newOutputStream(ofile), StandardCharsets.UTF_8)) {

            Scanner scanner = new Scanner(reader);
            int number = scanner.nextInt();
            int absNumber = Math.abs(number);
            int sum = 1;
            if(absNumber > 0 && absNumber <= MAX_VALUE) {
                int n = Math.abs(number - 1) + 1;
                sum = (number + 1) * n / 2;
            }

            writer.write(Integer.toString(sum));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}