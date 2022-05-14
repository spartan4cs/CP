import java.util.ArrayList;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> forP = node2root(root, p);
        ArrayList<TreeNode> forQ = node2root(root, q);

        int i = forP.size() - 1;

        int j = forQ.size() - 1;

        while (i >= 0 && j >= 0 && forP.get(i).val == forQ.get(j).val) {
            i--;
            j--;
        }
        i++;
        // j++;
        return forP.get(i);

    }

    private ArrayList<TreeNode> node2root(TreeNode root, TreeNode d) {

        if (root == null) {
            return new ArrayList<>();

        }
        if (root.val == d.val) {
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }

        ArrayList<TreeNode> l = node2root(root.left, d);
        if (l.size() > 0) {
            l.add(root);
            return l;
        }
        ArrayList<TreeNode> r = node2root(root.right, d);
        if (r.size() > 0) {
            r.add(root);
            return r;
        }
        return new ArrayList<>();
    }
}
// @lc code=end
