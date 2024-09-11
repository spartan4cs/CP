/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = Integer.MAX_VALUE, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prev != nums[i]) {

                nums[count] = nums[i];
                count++;
                prev = nums[i];
            }
        }
        return count;
    }
}
// @lc code=end

