/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count]=nums[i];
                count++;
            }
        }
        System.out.print(count);
        return count;
    }
}
// @lc code=end

