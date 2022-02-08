import java.util.Arrays;

class Leet646 {
    public static void main(String[] args) {

    }

    // leetcode 646, https://leetcode.com/problems/maximum-length-of-pair-chain/
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            return a[1] - b[1];
        });

        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < pairs.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}