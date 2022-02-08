
class LIS {
    public static void main(String[] args) {
        System.out.println(lis(new int[] { 1, 2, 3, 4, 67, 2, 12, 12, 3, 4 })); // LIS
        System.out.println(lds(new int[] { 1, 2, 3, 4, 67, 2, 12, 12, 3, 4 })); // LDS

    }

    // longest increasing subsequence
    private static int lis(int[] arr) {
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
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // longest decreasing subsequence
    private static int lds(int[] arr) {
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
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}