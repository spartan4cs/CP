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

        // word k selection 4
        HashMap<Integer, Integer> fmap = new HashMap<>();
        HashSet<Integer> st = new HashSet<>();

        for (int i : candidates) {
            fmap.put(i, fmap.getOrDefault(i, 0) + 1);
            st.add(i);

        }
        Integer[] uniqueCandidate = new Integer[st.size()];
        st.toArray(uniqueCandidate);
        return helper(candidates, target, 0, fmap, uniqueCandidate);
    }

    private List<List<Integer>> helper(int[] candidates, int target, int lc, HashMap<Integer, Integer> fmap,
            Integer[] uniqueCandidate) {
        if (target == 0) {
            List<List<Integer>> bans = new ArrayList<>();
            bans.add(new ArrayList<>());
            return bans;

        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = lc; i < uniqueCandidate.length; i++) {

            int currentCandidate = uniqueCandidate[i];
            if (fmap.get(currentCandidate) > 0 && target - currentCandidate >= 0) {

                fmap.put(currentCandidate, fmap.get(currentCandidate) - 1);
                List<List<Integer>> lans = helper(candidates, target - currentCandidate, i, fmap, uniqueCandidate);
                if (lans.size() > 0) {
                    for (List<Integer> l : lans) {
                        l.add(currentCandidate);
                        ans.add(l);

                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
