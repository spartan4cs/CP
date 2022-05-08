import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        return helper(candidates, target, -1);
    }

    private List<List<Integer>> helper(int[] candidates, int target, int lc) {
        if (target == 0) {
            List<List<Integer>> bans = new ArrayList<>();
            bans.add(new ArrayList<>());
            return bans;

        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = lc + 1; i < candidates.length; i++) {
            if (i != lc + 1 && candidates[i] == candidates[i - 1]) {

                // skip if same number as option in curent level
                // dont skip if it is 1st occurence  at new level
                continue;
            }
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
