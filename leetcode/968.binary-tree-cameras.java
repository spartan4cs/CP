/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
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
    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (helper(root) == -1)
            count++;
        return count;
    }

    // 3 state
    // -1 = need camera,
    // 0 ,placed camera,
    // 1 - iam cover by child

    public int helper(TreeNode root) {
        if (root == null) {
            return 1;

        }
        int l = helper(root.left);
        int r = helper(root.right);

        if (l == -1 || r == -1) {
            count++; // increase camera
            return 0;
        }
        if (l == 0 || r == 0) {
            return 1;
        }
        return -1;
    }
}
// @lc code=end
