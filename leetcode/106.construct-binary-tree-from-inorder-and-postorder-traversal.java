/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = postorder.length;
        int m = inorder.length;
        return helper(postorder, 0, n - 1, inorder, 0, m - 1);
    }

    private TreeNode helper(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {

        if (isi > iei) {
            return null;
        }

        // find root in inorder
        int idx = isi;
        while (inorder[idx] != postorder[pei]) {
            idx++;
        }

        // count of left subtree elemtn
        int colse = idx - isi;

        TreeNode node = new TreeNode(inorder[idx]);

        node.left = helper(postorder, psi , psi + colse-1, inorder, isi, idx - 1);
        node.right = helper(postorder, psi + colse , pei-1, inorder, idx + 1, iei);
        return node;
    }
}
// @lc code=end
