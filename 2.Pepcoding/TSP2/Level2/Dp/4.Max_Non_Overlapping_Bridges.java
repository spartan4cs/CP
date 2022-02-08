import java.util.Arrays;

class Max_Non_Overlapping_Bridges {

    public static void main(String[] args) {

    }

    // maximm non overlapping bridges
    private static class Bridges implements Comparable<Bridges> {
        int n;
        int s;

        public Bridges(int n, int s) {
            this.n = n;
            this.s = s;
        }

        public int compareTo(Bridges o) {
            if (this.n != o.n) {
                return this.n - o.n;
            } else {
                return this.s - o.s;
            }
        }
    }

    private static int nonOverlappingBridges(int[][] bridges) {
        Bridges[] arr = new Bridges[bridges.length];
        for (int i = 0; i < bridges.length; i++) {
            arr[i] = new Bridges(bridges[i][0], bridges[i][1]);
        }

        // ort north pole
        Arrays.sort(arr);
        // LIS on south pole
        int[] dp = new int[arr.length];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].s < arr[i].s) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
