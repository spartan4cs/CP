import java.util.Scanner;

public class ClimbStairVariableJumps {
    public static void main(String[] args) {

        // 1. You are given a number n, representing the number of stairs in a
        // staircase.
        // 2. You are on the 0th step and are required to climb to the top.
        // 3. You are given n numbers, where ith element's value represents - till how
        // far from the step you
        // could jump to in a single move.
        // You can of course jump fewer number of steps in the move.
        // 4. You are required to print the number of different paths via which you can
        // climb to the top.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        // ans = csvb_rec(arr, 0, n);
        // ans = csvb_mem(arr, 0, n);
        ans = csvb_tab2(arr, n);// converting mem to tab

        // ans = csvb_tab1(n, arr);
        System.out.println(ans);
    }

    public static int csvb_tab2(int arr[], int N) {
        int dp[] = new int[N + 1];
        for (int i = N; i >= 0; i--) {
            if (i == N) {
                dp[i] = 1;
                continue;
            }

            int count = 0;
            for (int j = 1; j <= arr[i] && i + j <= N; j++) {

                int rr = dp[i + j];
                count += rr;
            }
            dp[i] = count;
        }
        return dp[0];

    }

    public static int csvb_mem(int arr[], int i, int n) {

        int dp[] = new int[n + 1];
        if (i == n) {
            dp[i] = 1;
            return 1;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        int count = 0;
        for (int j = 1; j <= arr[i] && i + j <= n; j++) {

            int rr = csvb_rec(arr, i + j, n);
            count += rr;
        }
        dp[i] = count;
        return count;

    }

    public static int csvb_rec(int arr[], int i, int n) {

        if (i == n) {
            return 1;
        }
        int count = 0;
        for (int j = 1; j <= arr[i] && i + j <= n; j++) {

            int rr = csvb_rec(arr, i + j, n);
            count += rr;
        }
        return count;

    }

    public static int csvb_tab1(int n, int[] arr) {

        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j <= n; j++) {
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }
}
