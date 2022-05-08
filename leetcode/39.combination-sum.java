import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return helper(candidates, target, 0);
    }

    private List<List<Integer>> helper(int[] candidates, int target, int lc) {
        if (target == 0) {
            List<List<Integer>> bans = new ArrayList<>();
            bans.add(new ArrayList<>());
            return bans;

        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = lc; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {

                List<List<Integer>> lans = helper(candidates, target - candidates[i], i);
                if (lans.size() > 0) {
                    for (List<Integer> l : lans) {
                        l.add(candidates[i]);
                        ans.add(l);

                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
