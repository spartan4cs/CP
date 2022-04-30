import java.util.Arrays;

/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */

// @lc code=start
class Solution {
    boolean flag = false;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        sum = sum / k;
        solution(nums, n - 1, k, sum, 0, new int[k]);
        return flag;

    }

    // nos- no of set filled
    private void solution(int[] nums, int i, int k, int sum, int nos, int[] ans) {

        if (i == -1) {
            if (nos == k) {
                // for (int j : ans) {
                // System.out.print(j + " ");
                // }
                // System.out.println();
                // boolean allMatch = Arrays.stream(ans).allMatch(t -> t == sum);
                // if (allMatch) {
                // flag = true;

                // return;
                // }

                boolean lflag = true;
                for (int j = 0; j < ans.length; j++) {
                    if (sum != ans[j]) {
                        lflag = false;
                        break;
                    }

                }
                if (lflag) {
                    flag = true;
                    return;
                }
            }
            return;
        }

        for (int j = 0; j < k; j++) {

            if (ans[j] + nums[i] <= sum) {

                if (ans[j] != 0) {
                    ans[j] += nums[i];
                    solution(nums, i - 1, k, sum, nos, ans);
                    ans[j] -= nums[i];
                } else
                // empy set
                if (ans[j] == 0) {

                    ans[j] += nums[i];
                    solution(nums, i - 1, k, sum, nos + 1, ans);
                    ans[j] -= nums[i];
                    break;// to avoid multiple times adding to empty set
                }
            }
        }
    }
}
// @lc code=end
