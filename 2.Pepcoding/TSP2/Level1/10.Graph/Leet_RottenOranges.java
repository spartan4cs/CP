import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Leet_RottenOranges {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            System.out.println(new A().orangesRotting(grid));
        }
    }
}

class A {

    class Pair {
        int x, y, t;

        Pair(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] graph) {

        int n = graph.length;
        int m = graph[0].length;

        int orange = 0;
        Queue<Pair> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (graph[i][j] == 2) {
                    qu.add(new Pair(i, j, 0));
                    orange++;
                } else if (graph[i][j] == 1) {
                    orange++;
                }
            }
        }

        if (orange == 0)
            return 0;

        int xdir[] = { -1, 0, 1, 0 };
        int ydir[] = { 0, -1, 0, 1 };

        // bfs
        int time = -1;
        while (qu.size() > 0) {

            Pair rem = qu.remove();

            if (graph[rem.x][rem.y] == -1) {
                continue;
            }
            graph[rem.x][rem.y] = -1;
            time = rem.t;
            orange--;// fresh orange processed
            for (int d = 0; d < 4; d++) {
                int ni = rem.x + xdir[d];
                int nj = rem.y + ydir[d];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && graph[ni][nj] == 1) {
                    qu.add(new Pair(ni, nj, rem.t + 1));
                }
            }
        }
        return orange == 0 ? time : -1;
    }
}