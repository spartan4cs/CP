import java.io.*;
import java.util.*;

class PaintHouseWithKColors {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = sc.nextInt();
            }

        }

        int ans = 0;
        ans = tab(arr, n, k);
        System.out.println(ans);
    }

    // Tabulation

    public static int tab(int[][] arr, int n, int k) {

        int dp[][] = new int[n][k];
        int pmin = Integer.MAX_VALUE;
        int psmin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            int cmin = Integer.MAX_VALUE;
            int csmin = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {

                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    if (dp[i - 1][j] == pmin) {
                        dp[i][j] = arr[i][j] + psmin;
                    } else {
                        dp[i][j] = arr[i][j] + pmin;
                    }

                }

                // find min and 2nd min
                if (dp[i][j] <= cmin) {
                    csmin = cmin;
                    cmin = dp[i][j];

                } else if (dp[i][j] < csmin) {
                    csmin = dp[i][j];
                }

            }
            pmin = cmin;
            psmin = csmin;
        }

        return pmin;
    }
}
