
import java.io.*;
import java.util.*;

public class PrintSingleChildNode {
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

    // aproach one using parent
    public static void printSingleChildNodes1(Node node, Node parent) {
        // write your code here

        if (node == null) {
            return;
        }

        if (parent != null && parent.left == node && parent.right == null) {
            // i am single left child
            System.out.println(node.data);
        }
        if (parent != null && parent.right == node && parent.left == null) {
            // i am single right child
            System.out.println(node.data);
        }

        printSingleChildNodes1(node.left, node);
        printSingleChildNodes1(node.right, node);
    }

    // aproach 2 without using parent
    public static void printSingleChildNodes(Node node) {
        // write your code here

        if (node == null)
            return;

        if (node.left != null && node.right == null) {
            System.out.println(node.left.data);
        }

        if (node.left == null && node.right != null) {
            System.out.println(node.right.data);
        }

        printSingleChildNodes(node.left);
        printSingleChildNodes(node.right);
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
        printSingleChildNodes(root);
        printSingleChildNodes1(root, null);

    }

}