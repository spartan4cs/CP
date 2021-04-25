import java.util.Scanner;

public class FloodFill {

    public static int[] rdir = { -1, 0, 1, 0 };
    public static int[] cdir = { 0, -1, 0, 1 };
    public static char[] chArr = { 't', 'l', 'd', 'r' };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        // int[][] arr = {

        // { 0, 1, 0, 0, 0, 0 },

        // { 0, 1, 0, 1, 1, 0 },

        // { 0, 1, 0, 1, 1, 0 },

        // { 0, 0, 0, 0, 0, 0 },

        // { 1, 1, 0, 1, 1, 0 },

        // { 1, 1, 0, 0, 0, 0 }

        // };

        floodfill(arr, 0, 0, "");
    }

    public static void floodfill(int[][] board, int sr, int sc, String asf) {

        if (sr == board.length - 1 && sc == board[0].length - 1) {
            System.out.println(asf);
            return;
        }

        // mark visited by makeing current cell 1 so it will not go to reverse direction
        board[sr][sc] = 1;

        for (int d = 0; d < rdir.length; d++) {
            int rr = sr + rdir[d];
            int cc = sc + cdir[d];
            char dir = chArr[d];

            // resttrict invalid paths
            if (rr >= 0 && rr < board.length && cc >= 0 && cc < board[0].length) {
                // obstaclle
                if (board[rr][cc] != 1) {

                    floodfill(board, rr, cc, asf + dir);
                }
            }
        }
        // unmark so all path can be visited
        board[sr][sc] = 0;
    }
}
