import java.util.Arrays;

/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */

// @lc code=start
class Solution {
    static boolean flag = false;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        solution(nums, 0, k, "", 0, new int[k]);
        return flag;

    }

    // nos- no of set filled
    private static void solution(int[] nums, int i, int k, String asf, int nos, int[] ans) {

        if (i == nums.length) {
            if (nos == k) {
                // for (int j : ans) {
                // System.out.print(j + " ");
                // }
                // System.out.println();
                boolean allMatch = Arrays.stream(ans).allMatch(t -> t == ans[0]);
                if (allMatch) {
                    flag = true;

                    return;
                }
            }
            return;
        }

        for (int j = 0; j < k; j++) {

            if (ans[j] != 0) {
                ans[j] += nums[i];
                solution(nums, i + 1, k, asf, nos, ans);
                ans[j] -= nums[i];
            }
            // empy set
            if (ans[j] == 0) {

                ans[j] += nums[i];
                solution(nums, i + 1, k, asf, nos + 1, ans);
                ans[j] -= nums[i];
                break;// to avoid multiple times adding to empty set
            }
        }
    }
}
// @lc code=end
