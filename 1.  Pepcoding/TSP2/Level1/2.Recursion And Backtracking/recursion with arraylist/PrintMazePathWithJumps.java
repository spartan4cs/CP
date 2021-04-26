import java.util.Scanner;

public class PrintMazePathWithJumps {

    public static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String asf) {

        if (sr == dr && sc == dc) {
            System.out.println(asf);
            return;
        }

        if (sr >= 0 && sc >= 0 && sr <= dr && sc <= dc) {

            for (int i = 1; i <= dc; i++) {// jumps

                printMazePathWithJumps(sr, sc + i, dr, dc, asf + "h" + i);
            }
            for (int i = 1; i <= dr; i++) {

                printMazePathWithJumps(sr + i, sc, dr, dc, asf + "v" + i);
            }
            for (int i = 1; i <= dr && i <= dc; i++) {

                printMazePathWithJumps(sr + i, sc + i, dr, dc, asf + "d" + i);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        printMazePathWithJumps(0, 0, n - 1, m - 1, "");
    }
}
