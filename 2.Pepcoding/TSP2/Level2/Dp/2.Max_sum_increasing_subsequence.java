class Max_sum_increasing_subsequence {

    public static void main(String[] args) {
        System.out.println(maxSumLIS(new int[] { 1, 2, 3, 4, 67, 2, 12, 12, 3, 4 }));

    }

    // maximum sum increasing subsequence
    private static int maxSumLIS(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // int max = 0;
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            // dp[i] = max + arr[i];
            if (max == Integer.MIN_VALUE) {
                dp[i] = arr[i];
            } else {
                dp[i] = max + arr[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
