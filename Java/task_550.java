import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.Scanner;

public class task_550 {
    public static void main(String[] args) {
        Path ifile = Paths.get("INPUT.TXT");
        Path ofile = Paths.get("OUTPUT.TXT");

        try(Reader reader = new InputStreamReader(Files.newInputStream(ifile), StandardCharsets.UTF_8);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(Files.newOutputStream(ofile), StandardCharsets.UTF_8), false) ) {
            Scanner scanner = new Scanner(reader);
            int year = -1;
            LocalDate date = null;

            if(scanner.hasNextInt()){
                year = scanner.nextInt();
                date = LocalDate.of(year, 1, 1);
                date = date.plusDays(255);
                writer.printf("%02d/%02d/%04d\n", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
            }
            else scanner.next();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
