/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        // use stack to iterate bt preorder

        if (root == null) {
            return null;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        List<String> al = new ArrayList<>();
        while (!st.isEmpty()) {

            // rma
            // remove
            TreeNode c = st.pop();
            if (c == null) {
                al.add("null");
            } else {

                // print
                al.add("" + c.val);
                // add child(1st right then left bec for preorder traversal, left to be poped
                // first)
                st.push(c.right);
                st.push(c.left);
            }

        }

        return String.join(",", al);

    }

    static int t;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        t = 0;

        String arr[] = data.split(",");

        return helper(arr);
    }

    public TreeNode helper(String[] arr) {

        if (arr[t].equals("null")) {
            t++;
            return null;
        }

        TreeNode tn = new TreeNode(Integer.parseInt(arr[t++]));
        tn.left = helper(arr);
        tn.right = helper(arr);
        return tn;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
