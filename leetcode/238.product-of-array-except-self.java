/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // jatana 1st loop madhe
        // result madhe left product save kar

        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // yetana 2nd loop
        // result la right product sobat multiply kar
        // right product update kar

        int rp = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = result[i] * rp;
            rp = rp * nums[i];
        }
        return result;
    }
}
// @lc code=end
