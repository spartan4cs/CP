import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    // consider level at index and add in respective index
    // same lvel pe hoga toh add kar in particular index and list
    // using hashmap of index and List of nodeval
    // like we do in vertica order
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        helper(root, 0, map);
        int height = getHeight(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = height - 1; i >= 0; i--) {
            ans.add(map.get(i));
        }
        return ans;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }

    private void helper(TreeNode root, int level, HashMap<Integer, List<Integer>> map) {

        if (root == null) {
            return;
        }
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);
        helper(root.left, level + 1, map);
        helper(root.right, level + 1, map);

    }
}
// @lc code=end
