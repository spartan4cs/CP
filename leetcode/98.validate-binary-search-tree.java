/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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

    // --------approach1 - same logic that you would add for normal sorted arr to
    // check if
    // ti is sorted

    // TreeNode prev = null;

    // public boolean isValidBST(TreeNode root) {
    // // inorder traversal will give sorted list
    // if (root == null)
    // return true;

    // boolean leftcall = isValidBST(root.left);
    // if (!leftcall)
    // return false;

    // // inorder work
    // if (prev != null && prev.val >= root.val)
    // return false;
    // prev = root;

    // boolean rightcall = isValidBST(root.right);
    // if (!rightcall)
    // return false;

    // return true;
    // }

    // ---------------------approach2 pair

    // class BstPair {
    // long min;
    // long max;
    // boolean isbst;

    // BstPair() {
    // min = Long.MAX_VALUE;
    // max = Long.MIN_VALUE;
    // isbst = true;
    // }
    // }

    // public BstPair isBST(TreeNode node) {
    // if (node == null)
    // return new BstPair();
    // BstPair l = isBST(node.left);
    // BstPair r = isBST(node.right);

    // BstPair mres = new BstPair();
    // mres.min = Math.min(node.val, Math.min(l.min, r.min));
    // mres.max = Math.max(node.val, Math.max(l.max, r.max));
    // mres.isbst = l.isbst && r.isbst && l.max < node.val && r.min > node.val;
    // return mres;

    // }

    // public boolean isValidBST(TreeNode root) {
    // // if(root.left==null && root.right==null) return true;
    // return isBST(root).isbst;

    // }

    // --------------approache 3 using stack iterative BT inorder
    // public boolean isValidBST(TreeNode root) {
    // if (root == null)
    // return true;
    // Stack<TreeNode> stack = new Stack<>();
    // TreeNode pre = null;
    // while (root != null || !stack.isEmpty()) {
    // //add all left
    // while (root != null) {
    // stack.push(root);
    // root = root.left;
    // }
    // //inorder work
    // root = stack.pop();
    // if (pre != null && root.val <= pre.val)
    // return false;
    // pre = root;
    // //go to right
    // root = root.right;
    // }
    // return true;
    // }

    // ------------approach4 Morris traversal
    public boolean isValidBST(TreeNode root) {

        TreeNode prev = null;

        while (root != null) {

            TreeNode left = root.left;

            if (left == null) {

                // at this point(both inorder OR preoredr)
                if (prev != null && prev.val >= root.val) {
                    return false;
                }
                prev = root;
                // print
                System.out.println(root.val);

                // goto right
                root = root.right;
            } else {

                // get left ka extremen right
                TreeNode extremeRight = getExtremeRight(left, root);

                if (extremeRight.right == null) {
                    // create thread;
                    extremeRight.right = root;

                    // at this point (preorder)
                    // go to left
                    root = root.left;
                } else {

                    // destroy thread
                    extremeRight.right = null;

                    if (prev != null && prev.val >= root.val) {
                        return false;
                    }
                    prev = root;
                    // at this point (inorder)
                    // print
                    System.out.println(root.val);
                    // got to right
                    root = root.right;

                }

            }
        }
        return true;

    }

    public TreeNode getExtremeRight(TreeNode head, TreeNode curr) {

        while (head.right != null && head.right != curr) {
            head = head.right;
        }
        return head;
    }

}
// @lc code=end
