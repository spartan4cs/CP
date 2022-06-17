import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {

    // refered :https://www.youtube.com/watch?v=fYgU6Bi2fRg
    public boolean isEqualArr(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {

        int[] sHash = new int[26];
        int[] pHash = new int[26];

        int window = p.length();
        List<Integer> al = new ArrayList<>();
        if (s.length() < p.length()) {
            return al;
        }

        // sliding window of size p and compare shash with phash

        // create initial window

        int l = 0;
        int r = 0;
        while (r < window) {
            sHash[s.charAt(r) - 'a'] += 1;
            pHash[p.charAt(r) - 'a'] += 1;
            r++;
        }

        r--;

        while (r < s.length()) {

            if (isEqualArr(sHash, pHash)) {
                al.add(l);
            }

            r++;// add from end
            if (r != s.length())
                sHash[s.charAt(r) - 'a'] += 1;

            sHash[s.charAt(l) - 'a'] -= 1;
            l++;// remove from start

        }

        return al;
    }
}
// @lc code=end
