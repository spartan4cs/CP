/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String as) {
        String[] s = as.trim().split(" ");

        return s[s.length - 1].length();
    }
}
// @lc code=end
