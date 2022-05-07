import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int onum = target - nums[i];
            if (map.containsKey(onum) && i!=map.get(onum)) {
                return new int[] { i, map.get(onum) };
            }
        }
        return ans;

    }
}
// @lc code=end
