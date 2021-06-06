
import java.io.*;
import java.util.*;

public class IsBalancesBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        // write your code here
        // System.out.println(isBalanced(root).isbalance);
        System.out.println(isBalanced2(root));
    }

    static class BPair {
        int ht;
        boolean isbalance;

        public BPair() {
            this.ht = -1;
            isbalance = true;
        }
    }

    // Approach 1 O(n)
    public static BPair isBalanced(Node node) {

        if (node == null) {
            return new BPair();
        }

        BPair l = isBalanced(node.left);
        BPair r = isBalanced(node.right);

        BPair mres = new BPair();
        mres.ht = Math.max(l.ht, r.ht) + 1;
        mres.isbalance = l.isbalance && r.isbalance && (Math.abs(l.ht - r.ht)) <= 1;
        return mres;

    }

    // Approach2 O(n^2)

    public static int getheight(Node node) {

        if (node == null) {
            return -1;
        }

        int l = getheight(node.left);
        int r = getheight(node.right);
        return Math.max(l, r) + 1;

    }

    public static boolean isBalanced2(Node node) {

        if (node == null) {
            return false;
        }

        int lh = getheight(node.left);
        int rh = getheight(node.right);

        int factor = Math.abs(lh - rh + 1);

        if (factor <= 1) {
            return true;
        }

        return isBalanced2(node.left) && isBalanced2(node.right);
    }
}