import java.io.*;
import java.util.*;

class Tiling2x1 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int dp[] = new int[n + 1];
        // ans= recursion(n);
        // ans = memo(n,dp);
        // ans = tab1(n,dp);
        ans = tab2(n, dp);
        System.out.println(ans);
    }

    // recursion

    public static int recursion(int n) {

        if (n == 1 || n == 2) {
            return n;
        }
        int ans = recursion(n - 1) + recursion(n - 2);
        return ans;

    }

    // memorization

    public static int memo(int n, int[] dp) {

        if (n == 1 || n == 2) {
            return dp[n] = n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = memo(n - 1, dp) + memo(n - 2, dp);
        return dp[n] = ans;
    }

    // tabulation1

    public static int tab1(int N, int[] dp) {
        for (int n = 1; n <= N; n++) {
            if (n == 1 || n == 2) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2]; // memo(n-1,dp)+memo(n-2,dp);
            dp[n] = ans;

        }
        return dp[N];

    }

    // tabulation 2
    public static int tab2(int N, int[] dp) {

        dp[1] = 1;
        dp[2] = 2;
        for (int n = 3; n <= N; n++) {
            int ans = dp[n - 1] + dp[n - 2]; // memo(n-1,dp)+memo(n-2,dp);
            dp[n] = ans;

        }
        return dp[N];

    }

}
