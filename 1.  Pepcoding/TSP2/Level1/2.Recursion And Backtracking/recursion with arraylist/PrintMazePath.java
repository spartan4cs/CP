import java.util.Scanner;

public class PrintMazePath {

    public static void printMazePath(int sr, int sc, int dr, int dc, String asf) {

        if (sr == dr && sc == dc) {
            System.out.println(asf);
            return;
        }
        if (sr >= 0 && sc >= 0 && sr <= dr && sc <= dc) {
            printMazePath(sr, sc + 1, dr, dc, asf + "h");

            printMazePath(sr + 1, sc, dr, dc, asf + "v");

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        printMazePath(0, 0, n - 1, m - 1, "");
    }

}
