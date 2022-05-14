import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {

    // linked list as stack
    // add first and remove first
    // using stack
    LinkedList<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new LinkedList<>();
        addAllLeft(root);
    }

    private void addAllLeft(TreeNode root) {

        while (root != null) {
            st.addFirst(root);

            root = root.left;
        }
    }

    public int next() {

        TreeNode t = st.removeFirst();

        addAllLeft(t.right);
        return t.val;
    }

    public boolean hasNext() {

        return st.size() != 0;
    }

    // using morris traversal
    // TreeNode curr = null;
    // int res;

    // public BSTIterator(TreeNode root) {

    // curr = root;
    // res = 0;
    // }

    // private void morris() {

    // while (curr != null) {
    // TreeNode leftNode = curr.left;
    // if (leftNode == null) {
    // res = curr.val;
    // curr = curr.right;
    // break;
    // } else {
    // TreeNode rightExtreme = getRightExtremeNode(leftNode, curr);

    // if (rightExtreme.right == null) {
    // rightExtreme.right = curr; // create thread
    // curr = curr.left;

    // } else {
    // rightExtreme.right = null; // destroy thread -- left is completly provcessews
    // res = curr.val;
    // curr = curr.right;
    // break;
    // }
    // }

    // }

    // }

    // private TreeNode getRightExtremeNode(TreeNode root, TreeNode curr) {

    // while (root.right != null && root.right != curr) {
    // root = root.right;
    // }
    // return root;
    // }

    // public int next() {
    // morris();
    // return res;
    // }

    // public boolean hasNext() {

    // return curr != null;
    // }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end
