/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int left = num / 10;
        int right = num % 10;
        return addDigits(left + right);

    }
}
// @lc code=end
