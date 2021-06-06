
import java.io.*;
import java.util.*;

public class LargestBSTSubtree {
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
        largestBstSt(root);
        System.out.println(bstnode.data + "@" + size);
    }

    static int size = 0;
    static Node bstnode = null;

    public static BSTPair largestBstSt(Node node) {

        if (node == null) {
            return new BSTPair();
        }

        BSTPair l = largestBstSt(node.left);
        BSTPair r = largestBstSt(node.right);

        BSTPair mres = new BSTPair();

        mres.min = Math.min(node.data, Math.min(l.min, r.min));
        mres.max = Math.max(node.data, Math.max(l.max, r.max));

        mres.isbalance = l.isbalance && r.isbalance && (l.max < node.data && r.min > node.data);
        mres.size = l.size + r.size + 1;

        if (mres.isbalance == true && mres.size > size) {
            bstnode = node;
            size = mres.size;
        }

        return mres;

    }

    public static class BSTPair {
        int min;
        int max;
        boolean isbalance;
        int size;

        public BSTPair() {
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.isbalance = true;
            this.size = 0;
        }
    }

}