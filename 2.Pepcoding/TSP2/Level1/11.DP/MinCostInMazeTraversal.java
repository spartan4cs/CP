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
        ans = tabulation(arr, 0, 0, n, m, qb);

        System.out.println(ans);

    }

    public static int recursion(int[][] arr, int x, int y, int n, int m) {

        if (x == n - 1 && y == m - 1) {
            return arr[x][y];
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

        return arr[x][y] + min;
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

    public static int tabulation(int[][] arr, int x, int y, int n, int m, int[][] qb) {

        for (int i = n; i >= 0; i--) {

            for (int j = n; j >= 0; j--) {

            }
        }
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
}
