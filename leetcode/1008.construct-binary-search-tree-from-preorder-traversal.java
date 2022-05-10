/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        // play with range

        return helper(preorder, -(int) 1e9 - 1, (int) 1e9 + 1);
    }

    private TreeNode helper(int[] preorder, int lb, int rb) {

        if (idx >= preorder.length || preorder[idx] < lb || preorder[idx] > rb) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[idx++]);
        node.left = helper(preorder, lb, node.val);
        node.right = helper(preorder, node.val, rb);
        return node;
    }
}
// @lc code=end
