import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 */

// @lc code=start
class Solution {
    List<Integer> al = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {

        for (int i = 1; i <= 9; i++) {
            helper(i, n);
        }
        return al;
    }

    private void helper(int i, int n) {

        if (i > n) {
            return;
        }
        al.add(i);
        for (int j = 0; j < 10; j++) {
            helper(10 * i + j, n);
        }
    }
}
// @lc code=end
