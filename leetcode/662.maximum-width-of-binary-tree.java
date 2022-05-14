import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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

    class Pair {
        TreeNode node;
        int idx;

        Pair(TreeNode n, int i) {
            node = n;
            idx = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int max = 0;
        while (q.size() > 0) {
            int size = q.size();
            int lm = q.peek().idx;
            int rm = q.peek().idx;
            while (size-- > 0) {

                Pair rem = q.remove();

                int index = rem.idx;
                rm = index;
                TreeNode cNode = rem.node;
                if (cNode.left != null) {
                    q.add(new Pair(cNode.left, 2 * index + 1));
                }

                if (cNode.right != null) {
                    q.add(new Pair(cNode.right, 2 * index + 2));
                }
            }
            max = Math.max(max, rm - lm + 1);

        }

        return max;
    }
}
// @lc code=end
