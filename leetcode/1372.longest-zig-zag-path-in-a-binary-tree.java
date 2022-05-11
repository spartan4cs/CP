/*
 * @lc app=leetcode id=1372 lang=java
 *
 * [1372] Longest ZigZag Path in a Binary Tree
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
    class Pair {
        int forward, backward;

        public Pair() {
            forward = -1;
            backward = -1;
        }

        public Pair(int f, int b) {

            forward = f;
            backward = b;
        }
    }

    int max = 0;

    public int longestZigZag(TreeNode root) {

        helper(root);
        return max;
    }

    public Pair helper(TreeNode root) {

        if (root == null) {
            return new Pair();
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        max = Math.max(max, Math.max(left.backward, right.forward) + 1);
        return new Pair(left.backward + 1, right.forward + 1);
    }
}
// @lc code=end
