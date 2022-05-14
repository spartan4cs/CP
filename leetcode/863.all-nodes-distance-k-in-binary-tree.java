import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start

//  Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public void kleveldown(TreeNode root, int k, TreeNode blockage, List<Integer> list) {

        if (root == null || root == blockage || k < 0) {
            return;

        }

        if (k == 0) {
            // ans
            list.add(root.val);
            return;

        }
        kleveldown(root.left, k - 1, blockage, list);
        kleveldown(root.right, k - 1, blockage, list);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        nodeToRootPath(root, target, k, ans);
        return ans;

    }

    private int nodeToRootPath(TreeNode root, TreeNode target, int k, List<Integer> list) {

        if (root == null) {
            return -1;
        }
        if (root.val == target.val) {
            kleveldown(root, k-0, null, list);
            return 1;
        }
        int ld = nodeToRootPath(root.left, target, k, list);
        if (ld != -1) {
            kleveldown(root, k - ld, root.left, list);
            return ld + 1;
        }
        int rd = nodeToRootPath(root.right, target, k, list);
        if (rd != -1) {
            kleveldown(root, k - rd, root.right, list);
            return rd + 1;
        }

        return -1;
    }
}
// @lc code=end
