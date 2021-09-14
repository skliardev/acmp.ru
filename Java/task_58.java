import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
 
public class task_58 {
    public static void main(String[] args) {
        Path ifile = Paths.get("INPUT.TXT");
        Path ofile = Paths.get("OUTPUT.TXT");
 
        try(Reader reader = new InputStreamReader(Files.newInputStream(ifile), StandardCharsets.UTF_8);
            Writer writer = new OutputStreamWriter(Files.newOutputStream(ofile), StandardCharsets.UTF_8)) {
            Scanner scanner = new Scanner(reader).useDelimiter("\\n|\\r\\n|\\s");
            int size = scanner.nextInt();
            while (scanner.hasNext()) {
                int m = scanner.nextInt();
                int n = scanner.nextInt();
                if(n < 2 || m < 2) {
                    for (int i=0; i<n*m; ++i) scanner.nextInt();
                    writer.write("YES\n");
                    continue;
                }
                int[][] arr = new int[m][n];
                for (int i = 0; i < m; ++i)
                    for (int j = 0; j < n; ++j)
                        arr[i][j] = scanner.nextInt();
                cheker:
                {
                    for (int i = 0; i < m - 1; ++i) {
                        for (int j = 0; j < n - 1; ++j) {
                            if ((arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1]) % 4 == 0) {
                                writer.write("NO\n");
                                break cheker;
                            }
                        }
                    }
                    writer.write("YES\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}