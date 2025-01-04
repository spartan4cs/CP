
import java.io.*;
import java.util.*;

public class DiameterGT {
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

    static int diameter = 0;

    public static int diameter1(Node node) {

        int maxhgt = -1;
        int smaxhgt = -1;

        for (Node child : node.children) {
            int ht = diameter1(child);
            if (ht >= maxhgt) {
                smaxhgt = maxhgt;
                maxhgt = ht;
            } else if (ht > smaxhgt) {
                smaxhgt = ht;
            }
        }
        int candidate = maxhgt + smaxhgt + 2;
        if (candidate > diameter) {
            diameter = candidate;
        }
        maxhgt += 1;
        return maxhgt;
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
        diameter1(root);
        // diameter2(root);
        System.out.println(diameter);
    }

}