import java.util.ArrayList;
import java.util.Scanner;

public class GoldMine2 {
    static int max = 0;

    static int sum = 0;

    public static void getMaxGold(int[][] arr) {
        // write your code here

        boolean[][] vis = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] != 0 && !vis[i][j]) {

                    sum = 0;
                    max = Math.max(max, dfs(arr, i, j, vis));

                }
            }
        }
    }

    static int rdir[] = { -1, 0, 1, 0 };
    static int cdir[] = { 0, -1, 0, 1 };

    private static int dfs(int[][] arr, int r, int c, boolean[][] vis) {

        vis[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + rdir[i];
            int nc = c + cdir[i];
            if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length && arr[nr][nc] != 0
                    && !vis[nr][nc]) {
                dfs(arr, nr, nc, vis);
            }

        }
        sum= sum + arr[r][c];
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
    }
}
