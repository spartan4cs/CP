import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    class Pair implements Comparable<Pair> {
        TreeNode node;
        int key;
        int level = 0;

        public Pair() {

        }

        public Pair(TreeNode node, int key, int level) {
            this.node = node;
            this.key = key;
            this.level = level;

        }

        // make this note
        @Override
        public int compareTo(Pair obj) {
            if (this.level == obj.level)
                return this.node.val - obj.node.val;

            return this.level - obj.level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // getwidth
        getWidth(root, 0);
        int width = max - min + 1;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < width; i++) {
            map.put(i, new ArrayList<>());
        }
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(root, Math.abs(min), 0));
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Pair rem = q.remove();
                map.get(rem.key).add(rem.node.val);
                if (rem.node.left != null) {
                    q.add(new Pair(rem.node.left, rem.key - 1, rem.level + 1));
                }
                if (rem.node.right != null) {
                    q.add(new Pair(rem.node.right, rem.key + 1, rem.level + 1));
                }
            }
        }
        // make ans
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    int min = 0;
    int max = 0;

    public void getWidth(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        min = Math.min(min, level);
        max = Math.max(max, level);
        getWidth(root.left, level - 1);
        getWidth(root.right, level + 1);

    }
}
// @lc code=end
