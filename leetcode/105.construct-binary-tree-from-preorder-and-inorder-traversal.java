/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;
        return helper(preorder, 0, n - 1, inorder, 0, m - 1);
    }

    private TreeNode helper(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {

        if (isi > iei) {
            return null;
        }

        // find root in inorder
        int idx = isi;
        while (inorder[idx] != preorder[psi]) {
            idx++;
        }

        // count of left subtree elemtn
        int colse = idx - isi;

        TreeNode node = new TreeNode(inorder[idx]);

        node.left = helper(preorder, psi + 1, psi + colse, inorder, isi, idx - 1);
        node.right = helper(preorder, psi + colse + 1, pei, inorder, idx + 1, iei);
        return node;
    }
}
// @lc code=end
