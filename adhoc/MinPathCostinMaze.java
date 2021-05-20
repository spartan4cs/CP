import java.util.Scanner;

public class MinPathCostinMaze {
    public static int[] rdir = { -1, 0, 1, 0 };
    public static int[] cdir = { 0, -1, 0, 1 };
    public static char[] chArr = { 't', 'l', 'd', 'r' };

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int m = scn.nextInt();
        // int[][] arr = new int[n][m];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // arr[i][j] = scn.nextInt();
        // }
        // }
        // int dr = scn.nextInt();
        // int dc = scn.nextInt();

        int[][] arr = {

                { 1, 1, 1, 1 }, { 1, 0, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 }

        };
        int ans = floodfill(arr, 0, 0, 2, 1, "", 0, 1000);
        // int ans = floodfill(arr, 0, 0, dr, dc, "", 0, 1000);
        ans = ans == 1000 ? -1 : ans;
        System.out.println(ans);
    }

    public static int floodfill(int[][] board, int sr, int sc, int dr, int dc, String asf, int count, int currMin) {

        if (sr == dr && sc == dc) {
            if (count < currMin)
                currMin = count;
            System.out.println(asf + " count - " + count + " currmin - " + currMin);
            return currMin;
        }

        // mark visited by makeing current cell 1 so it will not go to reverse direction
        board[sr][sc] = 0;

        for (int d = 0; d < rdir.length; d++) {
            int rr = sr + rdir[d];
            int cc = sc + cdir[d];
            char dir = chArr[d];

            // resttrict invalid paths
            if (rr >= 0 && rr < board.length && cc >= 0 && cc < board[0].length) {
                // obstaclle
                if (board[rr][cc] != 0) {
                    currMin = floodfill(board, rr, cc, dr, dc, asf + dir, count + 1, currMin);

                    // min = Math.min(min, 1 + f);
                }
            }
        }
        // unmark so all path can be visited
        board[sr][sc] = 1;
        return currMin;
    }
}
