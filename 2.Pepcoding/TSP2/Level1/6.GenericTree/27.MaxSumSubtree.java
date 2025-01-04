import java.io.*;
import java.util.*;

public class MaxSumSubtree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        max_sum_subtree(root);
        System.out.println(max_node.data + "@" + max_sum);
    }

    static int max_sum = Integer.MIN_VALUE;
    static Node max_node = null;

    public static int max_sum_subtree(Node node) {

        int sum = 0;

        for (Node child : node.children) {
            int cres = max_sum_subtree(child);
            sum = sum + cres;

        }
        sum += node.data;
        // max_sum = max(max_sum,sum)
        if (sum > max_sum) {
            max_sum = sum;
            max_node = node;
        }
        System.out.println("Node-data - > " + node.data + " respective sum -> " + sum);

        return sum;
    }
}