import java.io.*;
import java.util.*;

class FriendsPairing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int dp[] = new int[n + 1];
        // ans= recursive(n);
        // ans = memo(n,dp);
        // ans = tab1(n,dp);
        ans = tab2(n, dp);
        System.out.println(ans);

    }

    // recursive
    public static int recursive(int n) {

        // base
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = recursive(n - 1) + (n - 1) * recursive(n - 2);
        return ans;
    }

    // memorization

    public static int memo(int n, int[] dp) {

        // base
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }

        // refer
        if (dp[n] != 0) {
            return dp[n];
        }

        int ans = memo(n - 1, dp) + (n - 1) * memo(n - 2, dp);
        // store
        return dp[n] = ans;
    }

    // tabulation1

    public static int tab1(int N, int[] dp) {

        // base
        for (int n = 0; n <= N; n++) {
            if (n == 0 || n == 1) {
                dp[n] = 1;
                continue;
            }

            dp[n] = dp[n - 1] + (n - 1) * dp[n - 2]; // (n-1,dp)+(n-1)*memo(n-2,dp);

        }
        return dp[N];
    }

    // tabulation2

    public static int tab2(int N, int[] dp) {

        dp[0] = dp[1] = 1;

        // base
        for (int n = 2; n <= N; n++) {

            dp[n] = dp[n - 1] + (n - 1) * dp[n - 2]; // (n-1,dp)+(n-1)*memo(n-2,dp);

        }
        return dp[N];
    }

}
