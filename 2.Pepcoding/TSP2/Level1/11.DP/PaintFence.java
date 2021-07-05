import java.util.*;
import java.io.*;

class PaintFence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            // min = Math.min(min,rec(arr, n-1,i));
        }

        // min = tab(arr);
        min = tab2(arr);
        System.out.println(min);

    }

    // recursion
    public static int rec(int[][] arr, int r, int c) {
        if (r == -1) {
            return 0;
        }

        int left = rec(arr, r - 1, (c + 1) % 3) + arr[r][c];
        int right = rec(arr, r - 1, (c + 2) % 3) + arr[r][c];
        int min = Math.min(left, right);
        return min;

    }

    // tabulation

    public static int tab(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[arr.length - 1][i], min);
        }
        return min;
    }

    // tabulation sirs approach

    public static int tab2(int[][] arr) {

        int r = 0, g = 0, b = 0;

        for (int i = 0; i < arr.length; i++) {

            int nr = arr[i][0] + Math.min(g, b);
            int ng = arr[i][1] + Math.min(r, b);
            int nb = arr[i][2] + Math.min(r, g);

            // update old with new;
            r = nr;
            g = ng;
            b = nb;

        }
        return Math.min(r, Math.min(g, b));
    }

}
