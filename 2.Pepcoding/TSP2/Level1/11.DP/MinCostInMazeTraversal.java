import java.io.*;

import java.util.*;

// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
// 4. You are standing in top-left cell and are required to move to bottom-right cell.
// 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
// 6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
//      right cell).
// 7. You are required to traverse through the matrix and print the cost of path which is least costly.

//approach 
//dijkstra
//recursion
//dp

public class MinCostInMazeTraversal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // code

        int qb[][] = new int[n][m];
        int ans = 0;
        // ans= dijkstra();
        // ans = recursion(arr, 0, 0, n, m);
        // ans = memorization(arr, 0, 0, n, m, qb);
        // ans = tabulation1(arr, n, m, qb);
        ans = tabulation2(arr, n, m, qb);
        System.out.println(ans);

    }

    public static int recursion(int[][] arr, int x, int y, int n, int m) {

        if (x == n - 1 && y == m - 1) {
            return arr[x][y];
        }
        int h = (int) 1e9;
        int v = (int) 1e9;
        if (x + 1 < n) {

            h = recursion(arr, x + 1, y, n, m);
        }
        if (y + 1 < m) {

            v = recursion(arr, x, y + 1, n, m);
        }

        return arr[x][y] + Math.min(h, v);
    }

    public static int memorization(int[][] arr, int x, int y, int n, int m, int[][] qb) {

        if (x == n - 1 && y == m - 1) {
            return arr[x][y];
        }

        if (qb[x][y] != 0) {
            return qb[x][y];
        }
        int min = (int) 1e9;
        if (x + 1 < n) {

            int h = recursion(arr, x + 1, y, n, m);
            min = Math.min(min, h);
        }
        if (y + 1 < m) {

            int v = recursion(arr, x, y + 1, n, m);
            min = Math.min(min, v);
        }

        int res = arr[x][y] + min;
        qb[x][y] = res;
        return res;
    }

    public static int tabulation1(int[][] arr, int n, int m, int[][] qb) {

        for (int x = n - 1; x >= 0; x--) {

            for (int y = m - 1; y >= 0; y--) {
                if (x == n - 1 && y == m - 1) {
                    qb[x][y] = arr[x][y];
                    continue;
                }

                int min = (int) 1e9;
                if (x + 1 < n) {

                    int h = qb[x + 1][y];// recursion(arr, x + 1, y, n, m);
                    min = Math.min(min, h);
                }
                if (y + 1 < m) {

                    int v = qb[x][y + 1];// recursion(arr, x, y + 1, n, m);
                    min = Math.min(min, v);
                }

                int res = arr[x][y] + min;
                qb[x][y] = res;
            }
        }
        return qb[0][0];
    }

    public static int tabulation2(int[][] arr, int n, int m, int[][] dp) {

        for (int x = n - 1; x >= 0; x--) {

            for (int y = m - 1; y >= 0; y--) {
                if (x == n - 1 && y == m - 1) {
                    dp[x][y] = arr[x][y];
                    continue;
                } else if (x == n - 1) {
                    dp[x][y] = arr[x][y] + dp[x][y + 1];
                } else if (y == m - 1) {
                    dp[x][y] = arr[x][y] + dp[x + 1][y];
                } else {
                    dp[x][y] = arr[x][y] + Math.min(dp[x + 1][y], dp[x][y + 1]);
                }

            }
        }
        return dp[0][0];
    }
}
