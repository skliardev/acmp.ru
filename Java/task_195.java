import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class task_195 {
    public static void main(String[] args) {
        Path ifile = Paths.get("INPUT.TXT");
        Path ofile = Paths.get("OUTPUT.TXT");

        try(Reader reader = new InputStreamReader(Files.newInputStream(ifile), StandardCharsets.UTF_8);
            Writer writer = new OutputStreamWriter(Files.newOutputStream(ofile), StandardCharsets.UTF_8)) {
            Scanner scanner = new Scanner(reader);
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int sum = 2*n*a*b;
            writer.write(Integer.toString(sum));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
