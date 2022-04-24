import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Printpath_min_jumps {

    private static class Pair {
        int i; // index
        int j; // jump
        int minJ; // minjump
        String psf;// asf

        public Pair(int i, int j, int minJ, String psf) {
            this.i = i;
            this.j = j;
            this.minJ = minJ;
            this.psf = psf;
        }
    }

    public static void Solution(int arr[]) {
        // write your code here
        
        int n = arr.length;
        int[] dp = new int[n];

        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {

            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && i + j < n; j++) {
                min = Math.min(min, dp[i + j]);
            }

            dp[i] = min != Integer.MAX_VALUE ? 1 + min : Integer.MAX_VALUE;
        }
        System.out.println(dp[0]);

        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(0, arr[0], dp[0], "0"));

        while (q.size() > 0) {

            Pair rem = q.remove();

            if (rem.i == n - 1) {
                System.out.println(rem.psf + " .");
                continue;
            }
            for (int jump = 1; jump <= rem.j && rem.i + jump < n; jump++) {
                if (dp[rem.i + jump] == rem.minJ - 1) {
                    int ni = rem.i + jump;
                    q.add(new Pair(ni, arr[ni], dp[ni], rem.psf + " -> " + ni));
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }

}
