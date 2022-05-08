/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    // recursive solution with tle

    String max = "";

    public String longestPalindrome1(String s) {
        if (s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            String l = s.substring(0, i + 1);
            String r = s.substring(i + 1);
            if (isPalindrome(l)) {
                if (l.length() > max.length()) {
                    max = l;
                }
                longestPalindrome(r);
            }
        }
        return max;
    }

    private boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // using dp arr
    public String longestPalindrome(String s) {

        String max = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;

                    } else {
                        dp[i][j] = false;

                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;

                    } else {
                        dp[i][j] = false;

                    }
                }

                // check max
                if (dp[i][j]) {

                    String currentString = s.substring(i, j + 1);
                    if (currentString.length() > max.length()) {
                        max = currentString;
                    }
                }
            }
        }
        return max;
    }

}
// @lc code=end
