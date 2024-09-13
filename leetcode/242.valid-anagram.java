/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int in_s = s.charAt(i) - 'a';
            int in_t = t.charAt(i) - 'a';
            a[in_s] += 1;
            a[in_t] -= 1;

        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                return false;
            }
        }
        return true;
    }

    //other approach
    // class Solution {
    //     public boolean isAnagram(String s, String t) {
    //         char[] sChars = s.toCharArray();
    //         char[] tChars = t.toCharArray();
            
    //         Arrays.sort(sChars);
    //         Arrays.sort(tChars);
            
    //         return Arrays.equals(sChars, tChars);
    //     }
    // }
}
// @lc code=end
