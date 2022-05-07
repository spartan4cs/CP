/*
 * @lc app=leetcode id=2236 lang=java
 *
 * [2236] Root Equals Sum of Children
 */

// @lc code=start

//  Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean checkTree(TreeNode root) {
        if (root.val == root.left.val + root.right.val)
            return true;

        return false;
    }
}
// @lc code=end
