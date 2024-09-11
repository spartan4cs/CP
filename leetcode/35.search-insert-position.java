/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        
        return bs(nums, 0, nums.length-1, target);
    }

    public int bs(int[] arr, int l, int r, int t) {

        if (l > r) {
            return l;
        }
        int m = (l + r) / 2;
        if (arr[m] == t) {
            return m;
        }
        if (t < arr[m]) {
            return bs(arr, l, m - 1, t);
        } else if (t > arr[m]) {
            return bs(arr, m + 1, r, t);

        }
        return 0;
    }
}
// @lc code=end

