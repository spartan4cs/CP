/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int l = 1, r = x / 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long m2 = (long) m * m;
            if (x == m2) {
                return m;
            } else if (m2 < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
// @lc code=end

