/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    class pair {
        int with_rob;
        int without_rob;

        public pair() {
            with_rob = 0;
            without_rob = 0;
        }
    }

    public int rob(TreeNode root) {
        pair p = helper(root);
        return Math.max(p.with_rob, p.without_rob);
    }

    public pair helper(TreeNode root) {

        if (root == null) {
            return new pair();
        }
        pair l = helper(root.left);

        pair r = helper(root.right);

        pair p = new pair();
        p.with_rob = root.val + l.without_rob + r.without_rob;
        p.without_rob = Math.max(l.with_rob, l.without_rob) + Math.max(r.with_rob, r.without_rob);
        return p;
    }
}
// @lc code=end
