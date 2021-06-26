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
        for (int i = 0; i < n; i++) {

            int ans = recursion(arr, i, 0, n, m);
            res = Math.max(ans, res);

        }
        System.out.println(res);
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
}
