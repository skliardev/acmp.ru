import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Path inf = Paths.get("src\\INPUT.TXT");
        Path ouf = Paths.get("src\\OUTPUT.TXT");

        try(Scanner scanner = new Scanner(new InputStreamReader(Files.newInputStream(inf), StandardCharsets.UTF_8));
            Writer writer = new OutputStreamWriter(Files.newOutputStream(ouf), StandardCharsets.UTF_8)) {
            scanner.useDelimiter("\\n|\\r\\n|\\s");
            int value = 0;
            while(scanner.hasNextInt())
                value += scanner.nextInt();
            writer.write(Integer.toString(value));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
