import java.util.*;
import java.io.*;

public class GoldMine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // code

        int res = -(int) 1e9;
        int[][] qb = new int[n][m];
        // for (int i = 0; i < n; i++) {

        // int ans = -(int) 1e9;
        // // ans = recursion(arr, i, 0, n, m);
        // // ans = memorization(arr, i, 0, n, m, qb);
        // res = Math.max(ans, res);

        // }

        // for tabulation
        res = tabulation1(arr, n, m, qb);
        System.out.println(res);

        // print dp cost
        System.out.println();
        for (int i = 0; i < qb.length; i++) {
            for (int j = 0; j < qb[0].length; j++) {
                System.out.print(qb[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int recursion(int[][] arr, int x, int y, int n, int m) {

        if (y == m - 1) {
            return arr[x][y];
        }

        int maxGold = -(int) 1e9;
        if (x == 0) {

            int a = recursion(arr, x, y + 1, n, m);
            int b = recursion(arr, x + 1, y + 1, n, m);
            maxGold = Math.max(maxGold, Math.max(a, b));
        } else if (x == n - 1) {

            int a = recursion(arr, x - 1, y + 1, n, m);
            int b = recursion(arr, x, y + 1, n, m);
            maxGold = Math.max(maxGold, Math.max(a, b));

        } else {

            int a = recursion(arr, x - 1, y + 1, n, m);
            int b = recursion(arr, x, y + 1, n, m);
            int c = recursion(arr, x + 1, y + 1, n, m);
            maxGold = Math.max(maxGold, Math.max(a, Math.max(b, c)));
        }

        return maxGold + arr[x][y];
    }

    public static int memorization(int[][] arr, int x, int y, int n, int m, int[][] qb) {

        if (y == m - 1) {
            return arr[x][y];
        }

        if (qb[x][y] != 0) {
            return qb[x][y];
        }

        int maxGold = -(int) 1e9;
        if (x == 0) {

            int a = recursion(arr, x, y + 1, n, m);
            int b = recursion(arr, x + 1, y + 1, n, m);
            maxGold = Math.max(maxGold, Math.max(a, b));
        } else if (x == n - 1) {

            int a = recursion(arr, x - 1, y + 1, n, m);
            int b = recursion(arr, x, y + 1, n, m);
            maxGold = Math.max(maxGold, Math.max(a, b));

        } else {

            int a = recursion(arr, x - 1, y + 1, n, m);
            int b = recursion(arr, x, y + 1, n, m);
            int c = recursion(arr, x + 1, y + 1, n, m);
            maxGold = Math.max(maxGold, Math.max(a, Math.max(b, c)));
        }

        int res = maxGold + arr[x][y];
        qb[x][y] = res;
        return res;
    }

    public static int tabulation1(int[][] arr, int n, int m, int[][] qb) {

        for (int y = m - 1; y >= 0; y--) {
            for (int x = n - 1; x >= 0; x--) {
                if (y == m - 1) {
                    qb[x][y] = arr[x][y];
                    continue;
                }

                int maxGold = -(int) 1e9;
                if (x == 0) {

                    int a = qb[x][y + 1];// recursion(arr, x, y + 1, n, m);
                    int b = qb[x + 1][y + 1];// recursion(arr, x + 1, y + 1, n, m);
                    maxGold = Math.max(maxGold, Math.max(a, b));
                } else if (x == n - 1) {

                    int a = qb[x - 1][y + 1];// recursion(arr, x - 1, y + 1, n, m);
                    int b = qb[x][y + 1];// recursion(arr, x, y + 1, n, m);
                    maxGold = Math.max(maxGold, Math.max(a, b));
                } else {

                    int a = qb[x - 1][y + 1];// recursion(arr, x - 1, y + 1, n, m);
                    int b = qb[x][y + 1];// recursion(arr, x, y + 1, n, m);
                    int c = qb[x + 1][y + 1];// recursion(arr, x + 1, y + 1, n, m);
                    maxGold = Math.max(maxGold, Math.max(a, Math.max(b, c)));
                }

                int res = maxGold + arr[x][y];
                qb[x][y] = res;
            }

        }
        int res = 0;
        for (int i = 0; i < n; i++) {

            res = Math.max(res, qb[i][0]);

        }
        return res;
    }
}
