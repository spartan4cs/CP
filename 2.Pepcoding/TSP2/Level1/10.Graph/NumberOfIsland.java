import java.io.*;
import java.util.*;

public class NumberOfIsland {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here
        // given 2d arr

        // consider box as vertex
        // for every box

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    count++;
                    noofgcc(arr, i, j);
                }
            }
        }
        System.out.println(count);

    }

    static int rdir[] = { -1, 0, 1, 0 };
    static int cdir[] = { 0, -1, 0, 1 };

    public static void noofgcc(int[][] graph, int r, int c) {

        graph[r][c] = 1;
        for (int d = 0; d < 4; d++) {
            int nr = r + rdir[d];
            int nc = c + cdir[d];

            // valid graph && not visited
            if (nr >= 0 && nr < graph.length && nc >= 0 && nc < graph[0].length && graph[nr][nc] == 0) {
                noofgcc(graph, nr, nc);
            }
        }
    }
}
