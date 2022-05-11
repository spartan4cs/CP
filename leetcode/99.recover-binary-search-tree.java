/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 */

// @lc code=start

// Definition for a binary tree node.
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

    TreeNode a = null, b = null,
            prev = null;

    public void recoverTree(TreeNode root) {
        // bst mean inorder sorted
        // left- inorder- right
        helper(root);
        if (a != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }

    }

    int count = 0;

    public void helper(TreeNode root) {

        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != null && prev.val > root.val && count <= 2) {
            count++;
            b = root;
            if (a == null && count < 2) {
                a = prev;
            } else {
                return;
            }
        }
        prev = root;

        helper(root.right);
    }
}
// @lc code=end
