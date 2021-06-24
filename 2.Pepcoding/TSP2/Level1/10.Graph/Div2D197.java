import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Div2D197 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        Pair[][] vis = new Pair[n][m];
        int si = 0;
        int sj = 0;
        for (int i = 0; i < n; i++) {

            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'S') {
                    si = i;
                    sj = j;
                }
                vis[i][j] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }

        }
        getAns(arr, si, sj, vis, n, m);

        // String op = ans == true ? "Yes" : "No";
        System.out.println("No");
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.println(arr[i][j]);
        // }
        // }

    }

    static int xdir[] = { -1, 0, 1, 0 };
    static int ydir[] = { 0, -1, 0, 1 };

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean getAns1(char[][] arr, int si, int sj) {

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(si, sj));
        while (qu.size() > 0) {
            // rmwa
            Pair rem = qu.remove();

            // mark
            if (arr[rem.x][rem.y] == '1') {
                return true;
            }

            // add
            for (int d = 0; d < 4; d++) {
                int ni = rem.x + xdir[d];
                int nj = rem.y + ydir[d];
                if (ni == -1) {
                    ni += arr.length;
                }
                if (nj == -1) {
                    nj += arr[0].length;
                }
                if (ni == arr.length) {
                    ni = 0;
                }
                if (nj == arr[0].length) {
                    nj = 0;
                }
                if (arr[ni][nj] == '.') {
                    qu.add(new Pair(ni, nj));
                }

            }
        }
        return false;

    }

    // for chewcking we will use ni nad nj
    // for storing we will use
    public static void getAns(char[][] arr, int si, int sj, Pair[][] vis, int n, int m) {
        // System.out.println(si + " " + sj);
        int ni = ((si % n) + n) % n;
        int nj = ((sj % m) + m) % m; // 4 ,2

        if (vis[ni][nj].x == si && vis[ni][nj].y == sj) {
            return;
        }

        // base case
        if (vis[ni][nj].x != Integer.MAX_VALUE && vis[ni][nj].y != Integer.MAX_VALUE) {
            // System.out.println(si + " " + sj + " " + vis[ni][nj].x + " " +
            // vis[ni][nj].y);
            System.out.println("Yes");
            System.exit(0);
        }
        vis[ni][nj].x = si;
        vis[ni][nj].y = sj;
        for (int d = 0; d < 4; d++) {
            ni = si + xdir[d];
            nj = sj + ydir[d];
            ni = ((ni % n) + n) % n;
            nj = ((nj % m) + m) % m;
            if (arr[ni][nj] != '#') {

                getAns(arr, si + xdir[d], sj + ydir[d], vis, n, m);

            }

        }
    }

}
