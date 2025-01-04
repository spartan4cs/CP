import java.io.*;
import java.util.*;

public class LowestCommonAncestor {
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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    // can be managed using count
    // count the d1 and d2
    // if count ==2 thne next element is lca in post order
    public static int lca(Node node, int d1, int d2) {
        // write your code here
        ArrayList<Integer> arr1 = nodeToRootPath(node, d1);
        ArrayList<Integer> arr2 = nodeToRootPath(node, d2);

        int i = arr1.size() - 1;
        int j = arr2.size() - 1;
        int res = -1;
        while (i >= 0 && j >= 0 && arr1.get(i) == arr2.get(j)) {
            res = arr1.get(i);
            i--;
            j--;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        int lca = lca(root, d1, d2);
        System.out.println(lca);
        // display(root);
    }

}