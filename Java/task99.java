import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class task99 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), m = sc.nextInt(), n = sc.nextInt();
        int[][][] maze = new int[h][m][n];
        final int WAY = -1;
        final int WAL = -2;
        class Vertex extends Point {
            public int z;

            public Vertex(int x, int y, int z) {
                super(x, y);
                this.z = z;
            }

            public Vertex xplus() { return  new Vertex(x + 1, y, z); }
            public Vertex xminus() { return  new Vertex(x - 1, y, z); }
            public Vertex yplus() { return  new Vertex(x, y + 1, z); }
            public Vertex yminus() { return  new Vertex(x, y - 1, z); }
            public Vertex zplus() { return  new Vertex(x, y, z + 1); }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                Vertex vertex = (Vertex) o;
                return z == vertex.z;
            }

            public int hashCode() {
                return Objects.hash(super.hashCode(), z);
            }
        }
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vend = null;

        for (int k = 0; k < h; k++) {
            for (int j = 0; j < m; j++) {
                String line = sc.next();
                for (int i = 0; i < n; i++){
                    int el;
                    switch(line.charAt(i)) {
                        case '1': el = 0;
                            queue.add(new Vertex(i, j, k));
                            break;
                        case 'o': el = WAL;
                            break;
                        case '2':
                            vend = new Vertex(i, j, k);
                        case '.':
                        default: el = WAY;
                    }
                    maze[k][j][i] = el;
                }
            }
        }

        int step = 0;

        while (!queue.isEmpty()){
            Vertex cur = queue.poll();
            step = maze[cur.z][cur.y][cur.x];

            if(vend == null) break;

            if(cur.z < (h - 1) && maze[cur.z + 1][cur.y][cur.x] == WAY) {
                queue.add(cur.zplus());
                maze[cur.z + 1][cur.y][cur.x] = step + 1;
                if(cur.zplus().equals(vend)) { step++;  break; }
            }

            if(cur.y < (m - 1) && maze[cur.z][cur.y + 1][cur.x] == WAY) {
                queue.add(cur.yplus());
                maze[cur.z][cur.y + 1][cur.x] = step + 1;
                if(cur.yplus().equals(vend)) { step++;  break; }
            }

            if(cur.y > 0 && maze[cur.z][cur.y - 1][cur.x] == WAY) {
                queue.add(cur.yminus());
                maze[cur.z][cur.y - 1][cur.x] = step + 1;
                if(cur.yminus().equals(vend)) { step++;  break; }
            }

            if(cur.x < (n - 1) && maze[cur.z][cur.y][cur.x + 1] == WAY) {
                queue.add(cur.xplus());
                maze[cur.z][cur.y][cur.x + 1] = step + 1;
                if(cur.xplus().equals(vend)) { step++;  break; }
            }

            if(cur.x > 0 && maze[cur.z][cur.y][cur.x - 1] == WAY) {
                queue.add(cur.xminus());
                maze[cur.z][cur.y][cur.x - 1] = step + 1;
                if(cur.xminus().equals(vend)) { step++;  break; }
            }
        }
        System.out.printf("%d", 5*step);
    }
}
