/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int v[] = new int[strs.length];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> t = new ArrayList<>();

            if (v[i] == 0) {

                v[i] = 1;
                t.add(strs[i]);

            } else {
                continue;
            }
            for (int j = i + 1; j < strs.length; j++) {
                if (v[j] == 0 && isAnagram(strs[i], strs[j])) {
                    v[j] = 1;
                    t.add(strs[j]);
                } else {
                    continue;
                }

            }
            res.add(t);

        }
        return res;
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int in_s = s.charAt(i) - 'a';
            int in_t = t.charAt(i) - 'a';
            a[in_s] += 1;
            a[in_t] -= 1;

        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
