import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start

// Definition for a binary tree node.
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

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

            if (c != null) {

                // print
                al.add("" + c.val);
                // add child(1st right then left bec for preorder traversal, left to be poped
                // first)
                st.push(c.right);
                st.push(c.left);
            }

        }
        String ans = String.join(",", al);
        System.out.println(ans);
        return ans;

    }

    int t;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null)
            return null;
        t = 0;

        String arr[] = data.split(",");

        return helper(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode helper(String[] arr, int min, int max) {

        if (t >= arr.length) {
            return null;
        }
        int temp = Integer.parseInt(arr[t]);
        if ( temp < min || temp > max) {

            return null;
        }

        TreeNode tn = new TreeNode(Integer.parseInt(arr[t++]));
        tn.left = helper(arr, min, tn.val);
        tn.right = helper(arr, tn.val, max);
        return tn;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
