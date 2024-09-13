/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    // This reduces the time complexity from O(n^2 * m)
    // to O(n * m log m) (for sorting)
    // or O(n * m) (for frequency counting).

    // O(n^2* m=26 )
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

    // O(n * m log m), sorting takes mlogm
    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedS = new String(c);
            map.computeIfAbsent(sortedS, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());

    }

    // O(n * m)
    // Counting characters in each string takes O(m) time.
    // For n strings, the overall time complexity becomes O(n * m).
    public List<List<String>> groupAnagrams2(String[] strs) {
        // here we are removing the sorting and creating unique key
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {

            int count[] = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder uniquekey = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                uniquekey.append("#");
                uniquekey.append(count[i]);
            }

            map.computeIfAbsent(uniquekey.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());

    }

}
// @lc code=end
