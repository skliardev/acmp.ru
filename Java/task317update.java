import java.util.Scanner;

public class task317update {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt(), w = sc.nextInt();
        int sx = w/x;                   //max cycle for x
        int sum  = 0;

        for (int i = 0; i <= sx; i++){
            int lx = x*i;               //last x*i gram (iris)
            int ny = (w - lx)/y;        //exclude lx and get cycle for y
            for (int j = 0; j <= ny; j++){
                int ly = y*j;           //last y*j gram (mandarin)
                int lz = w - lx - ly;   //exclude lx + ly and get last gram for z
                if(lz % z == 0) sum++;  // w%(x or y or z) == 0 and (lx + ly + lz) == w, then sum++
            }
        }
        System.out.print(sum);
    }
}
