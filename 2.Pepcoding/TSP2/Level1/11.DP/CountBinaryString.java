import java.util.Scanner;

class CountBinaryString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = 0;
        int[] dp = new int[n + 1];
        int[] dp0 = new int[n + 1];

        int[] dp1 = new int[n + 1];

        // ans = recursion(n, 1);
        // ans = memo(n, 1, dp);
        // ans = tab(n, 1, dp0, dp1);

        ans = usingVar(n);
        System.out.println(ans);
    }

    public static int recursion(int n, int lastadded) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        if (lastadded == 1) {

            count += recursion(n - 1, 0);
            count += recursion(n - 1, 1);
        } else if (lastadded == 0) {
            count += recursion(n - 1, 1);
        }
        return count;
    }

    public static int memo(int n, int lastadded, int dp[]) {
        if (n == 0) {
            return dp[n] = 1;
        }

        // refer
        if (dp[n] != 0) {
            return dp[n];
        }
        int count = 0;
        if (lastadded == 1) {

            count += recursion(n - 1, 0);
            count += recursion(n - 1, 1);
        } else if (lastadded == 0) {
            count += recursion(n - 1, 1);
        }

        return dp[n] = count;// store
    }

    public static int tab(int N, int lastadded, int[] dp0, int[] dp1) {

        for (int n = 0; n <= N; n++) {
            if (n == 0) {
                dp0[n] = 1;
                dp1[n] = 1;
                continue;
            }

            int count = 0;

            dp1[n] += dp0[n - 1];// recursion(n - 1, 0);
            dp1[n] += dp1[n - 1];// recursion(n - 1, 1);
            dp0[n] += dp1[n - 1];// recursion(n - 1, 1);
        }
        return dp0[N - 1] + dp1[N - 1];
    }

    public static int usingVar(int n) {

        int oz = 1;
        int o1 = 1;
        for (int i = 2; i <= n; i++) {
            int nz = o1;
            int n1 = oz + o1;

            oz = nz;
            o1 = n1;
        }

        return oz + o1;
    }
}