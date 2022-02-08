class LBS {
    public static void main(String[] args) {
        System.out.println(lbs(new int[] { 1, 2, 3, 4, 67, 2, 12, 12, 3, 4 })); // LBS

    }

    // lbs -> longest bitonic subsequence
    private static int lbs(int[] arr) {
        int[] lis_ = lis(arr); // make a function of LIS and LDS which return DP rather than answer
        int[] lds_ = lds(arr);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            Math.max(ans, lis_[i] + lds_[i] - 1);
        }
        return ans;
    }

    // longest increasing subsequence
    private static int[] lis(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            // ans = Math.max(ans, dp[i]);
        }
        return dp;
    }

    // longest decreasing subsequence
    private static int[] lds(int[] arr) {
        int[] dp = new int[arr.length];
        dp[arr.length - 1] = 1;
        int ans = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            // ans = Math.max(ans, dp[i]);
        }
        return dp;
    }

}
