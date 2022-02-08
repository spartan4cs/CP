class GetLongestPalindromicSubstring {
    public static void main(String[] args) {

    }

    // leetcode 5, https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int x = 0;
        int y = 0;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] == true) {
                    // i and j represent substring from i to j
                    x = i;
                    y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }
}
