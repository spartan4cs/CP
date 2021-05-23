
import java.io.*;
import java.util.*;

public class LevelOrderLinewiseTraversal {
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

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);

        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }

    // approach 1 - using 2 queue
    public static void levelOrderLinewise(Node node) {
        // write your code here
        // you need to put extra line in levelorder traversal

        // approach1
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();

        mainQ.add(node);
        while (mainQ.size() > 0) {
            // RPA

            // remove
            Node rem = mainQ.remove();

            System.out.print(rem.data + " ");

            for (Node child : rem.children) {
                childQ.add(child);
            }
            if (mainQ.isEmpty()) {
                // hit enter
                System.out.println();

                // swap main and child
                Queue<Node> temp = mainQ;
                mainQ = childQ;
                childQ = temp;

            }
        }

    }

    // approach 2 using delimiter using single queue
    public static void levelOrderLinewiseDelimiter(Node node) {

        // using linkedlist as queue
        // because arrayDequeue does not allow usto add null
        Queue<Node> qu = new LinkedList<>();

        qu.add(node);
        qu.add(null);
        while (qu.size() > 0) {

            // remove
            Node rem = qu.remove();

            if (rem == null) { // if delimiter encountered
                System.out.println();
                if (qu.size() > 0)
                    qu.add(null);// only if qu size>0 else it will go to infinite
            } else {
                // print
                System.out.print(rem.data + " ");
                // add children
                for (Node child : rem.children) {
                    qu.add(child);
                }
            }

        }

    }

    // approach 3 using size of queue approach
    public static void levelOrderLinewiseQueueSize(Node node) {

        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        int height = 0;
        while (q.size() > 0) {

            // find size
            int sz = q.size();
            while (sz-- > 0) {
                // remove
                Node rem = q.remove();
                // print
                System.out.print(rem.data + " ");
                // add children
                q.addAll(rem.children);
            }
            // hit enter
            height++;
            System.out.println();

        }
        System.out.println(height);
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
        levelOrderLinewise(root);
        levelOrderLinewiseDelimiter(root);
        levelOrderLinewiseQueueSize(root);
    }

}