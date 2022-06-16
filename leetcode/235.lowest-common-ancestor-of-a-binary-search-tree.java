import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> pData = ntr(root, p);
        ArrayList<TreeNode> qData = ntr(root, q);

        // System.out.println(pData);
        // System.out.println(qData);

        int i = pData.size() - 1;
        while (pData.get(i).val == qData.get(i).val) {

            i--;
        }
        i++;
        return pData.get(i);
    }

    public List<TreeNode> ntr(TreeNode root, TreeNode p) {

        if (root.val == p.val) {
            List<TreeNode> b_ans = new ArrayList<>();
            b_ans.add(p.val);
            return b_ans;
        }
        if (root.left != null) {
            List<TreeNode> l = ntr(root.left, p);
            if (l.size() > 0) {
                l.add(root);
                return l;
            }
        }
        if (root.right != null) {
            List<TreeNode> r = ntr(root.right, p);
            if (r.size() > 0) {
                r.add(root);
                return r;
            }
        }
        return new ArrayList<>();
    }
}
// @lc code=end
