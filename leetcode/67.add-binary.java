/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int ibit = i >= 0 ? a.charAt(i) - '0' : 0;
            int jbit = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = ibit + jbit + carry;
            result.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
// @lc code=end

