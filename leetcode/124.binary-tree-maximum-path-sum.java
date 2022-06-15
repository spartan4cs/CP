/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    int max = Integer.MIN_VALUE;

    public int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int l = Math.max(helper(root.left), 0);
        int r = Math.max(helper(root.right), 0);

        max = Math.max(max, l + r + root.val);
        return root.val + Math.max(l, r);
    }

    public int maxPathSum(TreeNode root) {

        helper(root);
        return max;
    }
}
// @lc code=end
