import java.io.*;
import java.util.*;

class PartitionInKSubsetss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long ans = 0;
        long[][] dp = new long[n + 1][k + 1];
        // ans = recursion(n, k);
        // ans = memo(n,k,dp);
        // ans = tab1(n, k, dp);
        ans = tab2(n, k, dp);
        System.out.println(ans);

    }

    // recursion

    public static long recursion(int n, int k) {

        if (n == k) {
            return 1;
        } else if (k == 0) {
            return 0;
        }

        long left = recursion(n - 1, k); // i will get k subsets
        long right = recursion(n - 1, k - 1); // i will get k-1 subsets

        // in left ,last element will iterate through each subset
        // in right i will directly append it and make k subset

        long ans = left * k + right;
        return ans;
    }

    // memorization

    public static long memo(int n, int k, long[][] dp) {

        if (n == k) {
            return dp[n][k] = 1;
        } else if (k == 0) {
            return dp[n][0] = 0;
        }
        // refer
        if (dp[n][k] != 0) {
            return dp[n][k];
        }

        long left = memo(n - 1, k, dp); // i will get k subsets
        long right = memo(n - 1, k - 1, dp); // i will get k-1 subsets

        // in left ,last element will iterate through each subset
        // in right i will directly append it and make k subset

        long ans = left * k + right;
        return dp[n][k] = ans;

    }

    // tabulation1
    public static long tab1(int N, int K, long[][] dp) {
        for (int n = 1; n <= N; n++) {
            for (int k = 0; k <= K; k++) {
                if (n == k) {
                    dp[n][k] = 1;
                    continue;
                } else if (k == 0) {
                    dp[n][0] = 0;
                    continue;
                }

                long left = dp[n - 1][k];// memo(n-1,k,dp); //i will get k subsets
                long right = dp[n - 1][k - 1]; // memo(n-1,k-1,dp); //i will get k-1 subsets

                // in left ,last element will iterate through each subset
                // in right i will directly append it and make k subset

                long ans = left * k + right;
                dp[n][k] = ans;

            }

        }
        return dp[N][K];

    }

    // tabulation2
    public static long tab2(int N, int K, long[][] dp) {

        for (int n = 0; n <= N; n++) {
            for (int k = 0; n >= k && k <= K; k++) {
                if (n == k) {
                    dp[n][k] = 1;
                    continue;
                } else if (k == 0) {
                    dp[n][0] = 0;
                    continue;
                } else {

                    // i will get k subsets
                    long left = dp[n - 1][k];// memo(n-1,k,dp);

                    // i will get k-1 subsets
                    long right = dp[n - 1][k - 1]; // memo(n-1,k-1,dp);

                    // in left ,last element will iterate through each subset
                    // in right i will directly append it and make k subset

                    long ans = left * k + right;
                    dp[n][k] = ans;

                }
            }
        }
        return dp[N][K];

    }
}
