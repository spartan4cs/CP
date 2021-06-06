
import java.io.*;
import java.util.*;

public class IsBinarySearchTree {
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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
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
        System.out.println(isBST(root));
    }

    public static int getMax(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lmax = getMax(node.left);
        int rmax = getMax(node.right);

        return Math.max(node.data, Math.max(lmax, rmax));
    }

    public static int getMin(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int lm = getMin(node.left);
        int rm = getMin(node.right);

        return Math.min(node.data, Math.min(lm, rm));

    }

    // O(n^2) approach
    public static boolean isBST(Node node) {
        if (node == null) {
            return true;
        }

        int lmax = getMax(node.left);
        int rmin = getMin(node.right);
        if (lmax > node.data || rmin < node.data) {
            return false;
        }

        return isBST(node.left) && isBST(node.right);

    }

    static class BstPair {
        int min;
        int max;
        boolean isbst;

        public BstPair() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isbst = true;
        }

    }

    public static BstPair isBST1(Node node) {

        if (node == null) {
            return new BstPair();
        }
        BstPair l = isBST1(node.left);
        BstPair r = isBST1(node.right);

        BstPair mres = new BstPair();
        mres.min = Math.min(node.data, Math.min(l.min, r.min));
        mres.max = Math.max(node.data, Math.max(l.max, r.max));
        boolean status = l.max < node.data && r.min > node.data;
        mres.isbst = l.isbst && r.isbst && status;
        return mres;
    }

}