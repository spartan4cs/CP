import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int slen = s.length();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        // System.out.println(lastIndex);
        List<Integer> ans = new ArrayList<>();
        int itr = 0;
        int startIndex = 0;
        Integer endIndex = lastIndex.get(s.charAt(0));
        while (itr < slen) {

            Integer currEndIndex = lastIndex.get(s.charAt(itr));

            endIndex = Math.max(endIndex, currEndIndex);
            if (itr == endIndex) {
                ans.add(endIndex - startIndex + 1);
                startIndex = itr + 1;
                if (startIndex!=slen) {

                    endIndex = lastIndex.get(s.charAt(startIndex));
                }
            }

            itr++;
        }

        return ans;

    }
}
// @lc code=end
