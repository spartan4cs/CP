import java.io.*;
import java.util.*;

public class ClimbStair {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = 0;

        // ans = climbStair_rec(n);
        int qb[] = new int[n + 1];
        // ans = climbStair_memorization(n, qb);
        // ans = climbStair_tabulation(n);
        ans = climbStair_tabulation2(n);// to convert mem to tab
        System.out.println(ans);

    }

    public static int climbStair_tabulation(int n) {

        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[2] = dp[i - 1] + dp[i - 2];

            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    public static int climbStair_memorization(int n, int[] qb) {
        if (n == 0) {
            qb[0] = 1;
            return 1;
        }

        if (qb[n] != 0) {
            return qb[n];
        }

        int count = 0;
        for (int i = 1; i < 4; i++) {

            if (n - i >= 0) {
                int res = climbStair_rec(n - i);
                count += res;
            }

        }
        qb[n] = count;
        return count;
    }

    public static int climbStair_rec(int n) {

        if (n == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i < 4; i++) {

            if (n - i >= 0) {
                int res = climbStair_rec(n - i);
                count += res;
            }

        }
        return count;
    }

    // to convert from memorization to tabulation

    // for loop laga do
    /// repitiion nikal do
    public static int climbStair_tabulation2(int N) {

        int dp[] = new int[N + 1];
        for (int n = 0; n <=N; n++) {

            if (n == 0) {
                dp[0] = 1;
                continue;
            }

            int count = 0;
            for (int i = 1; i < 4; i++) {

                if (n - i >= 0) {
                    int res = dp[n - i];// climbStair_rec(n - i);
                    count += res;
                }

            }
            dp[n] = count;
        }

        return dp[N];
    }

}