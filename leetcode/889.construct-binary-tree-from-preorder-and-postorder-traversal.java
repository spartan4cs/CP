/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        int n = preorder.length;
        int m = postorder.length;
        return helper(preorder, 0, n - 1, postorder, 0, m - 1);
    }

    private TreeNode helper(int[] preorder, int psi, int pei, int[] postorder, int ppsi, int ppei) {

        if (psi > pei) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[psi]);
        if (psi == pei) {
            return node;
        }

        // find left subtree last index in post order
        int idx = ppsi;
        while (postorder[idx] != preorder[psi + 1]) {
            idx++;
        }

        // count of left subtree elemtn
        int colse = idx - ppsi + 1;

        node.left = helper(preorder, psi + 1, psi + colse, postorder, ppsi, idx);
        node.right = helper(preorder, psi + colse + 1, pei, postorder, idx + 1, ppei - 1);
        return node;
    }
}
// @lc code=end
