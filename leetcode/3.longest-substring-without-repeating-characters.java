import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a = 0;
        int b = 0;
        int ans = 0;
        HashSet<Character> hs = new HashSet<>();
        while (b < s.length()) {
            if (!hs.contains(s.charAt(b))) {
                hs.add(s.charAt(b));
                b++;
                ans = Math.max(ans, hs.size());
            } else {
                hs.remove(s.charAt(a));
                a++;
            }
        }
        return ans;
    }
}
// @lc code=end
