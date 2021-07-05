import java.util.*;
import java.io.*;

class Tilingmxn {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int ans = 0;
        int dp[][] = new int[m + 1][n + 1];
        // ans = recursion(m,n);
        // ans = memo(m,n,dp);
        int dp1[] = new int[n + 1];
        // ans = memo1(m,n,dp1);
        ans = tab1(m, n, dp1);
        // ans = tab2(m,n,dp1);

        System.out.println(ans);
    }

    // recursion

    public static int recursion(int m, int n) {
        int ans = 0;
        if (m > n) {
            return 1;
        } else if (m == n) {
            return 2;
        } else {
            ans = recursion(m, n - 1) + recursion(m, n - m);
        }

        return ans;
    }

    // memorization

    public static int memo(int m, int n, int[][] dp) {
        int ans = 0;
        if (m > n) {
            return dp[m][n] = 1;
        } else if (m == n) {
            return dp[m][n] = 2;
        } else if (dp[m][n] != 0) {
            return dp[m][n];
        } else {
            ans = memo(m, n - 1, dp) + memo(m, n - m, dp);
        }

        return dp[m][n] = ans;
    }

    // memorization1

    public static int memo1(int m, int n, int[] dp) {
        int ans = 0;
        if (m > n) {
            return dp[n] = 1;
        } else if (m == n) {
            return dp[n] = 2;
        } else if (dp[n] != 0) {
            return dp[n];
        } else {
            ans = memo1(m, n - 1, dp) + memo1(m, n - m, dp);
        }

        return dp[n] = ans;
    }

    // tabulation1

    public static int tab1(int m, int N, int[] dp) {

        for (int n = 1; n <= N; n++) {
            int ans = 0;
            if (m > n) {
                dp[n] = 1;
                continue;
            } else if (m == n) {
                dp[n] = 2;
                continue;
            } else {
                ans = dp[n - 1] + dp[n - m]; // memo1(m,n-1 ,dp)+memo1(m,n-m,dp);
            }

            dp[n] = ans;
        }
        return dp[N];

    }

}
