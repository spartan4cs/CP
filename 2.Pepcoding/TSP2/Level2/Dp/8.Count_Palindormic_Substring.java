class Count_Palindormic_Substring {
    public static void main(String[] args) {

    }

    // leetcode 647, https://leetcode.com/problems/palindromic-substrings/
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] == true)
                    count++;
            }
        }
        return count;
    }
}
