import java.util.Scanner;

public class ClimbStairwithMinMovesOrJumps {

    // 1. You are given a number n, representing the number of stairs in a
    // staircase.
    // 2. You are on the 0th step and are required to climb to the top.
    // 3. You are given n numbers, where ith element's value represents - till how
    // far from the step you
    // could jump to in a single move. You can of-course fewer number of steps in
    // the move.
    // 4. You are required to print the number of minimum moves in which you can
    // reach the top of
    // staircase.
    // Note -> If there is no path through the staircase print null.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] qb = new int[n + 1];

        int ans = 0;
        ans = cbmm_rec(arr, n, 0);
        // ans = cbmm_mem(arr, n, 0, qb);
        // ans = cbmm_tab1(arr, n, 0, qb);
        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        System.out.println(ans);
    }

    public static int cbmm_rec(int[] arr, int n, int i) {

        if (i == n) {
            // System.out.println(i);
            return 0;
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[i] && i + j <= n; j++) {

            // System.out.println(i + j);
            int rr = cbmm_rec(arr, n, i + j);
            mini = Math.min(rr, mini);
            // System.out.println(mini);
        }
        return mini != Integer.MAX_VALUE ? 1 + mini : Integer.MAX_VALUE;
    }

    public static int cbmm_mem(int[] arr, int n, int i, int[] qb) {

        if (i == n) {
            // System.out.println(i);
            return 0;
        }
        if (qb[i] != 0) {
            return qb[i];
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[i] && i + j <= n; j++) {

            // System.out.println(i + j);
            int rr = cbmm_mem(arr, n, i + j, qb);
            mini = Math.min(rr, mini);
            // System.out.println(mini);
        }

        mini = mini != Integer.MAX_VALUE ? 1 + mini : Integer.MAX_VALUE;

        // store in qb
        qb[i] = mini;
        return mini;
    }

    public static int cbmm_tab1(int[] arr, int n, int i, int[] qb) {

        for (i = n; i >= 0; i--) { // small to big problem
            if (i == n) {
                qb[i] = 0;
                continue;
            }

            int mini = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && i + j <= n; j++) {

                int rr = qb[i + j]; // instead of calling cbmm_mem(arr, n, i + j, qb); and removing the part where
                                    // we try to fetch from qb
                mini = Math.min(rr, mini);
            }

            mini = mini != Integer.MAX_VALUE ? 1 + mini : Integer.MAX_VALUE;

            qb[i] = mini;
        }
        return qb[0];
    }

}
