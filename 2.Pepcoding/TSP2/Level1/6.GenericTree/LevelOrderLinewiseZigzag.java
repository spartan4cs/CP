
import java.io.*;
import java.util.*;

public class LevelOrderLinewiseZigzag {
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

    public static void levelOrderLinewiseZZ(Node node) {
        // write your code here
        // write your code here

        // we will use 2 stack
        // for odd level add child from left to right
        // for even level add child from right to left

        Stack<Node> mainS = new Stack<>();
        Stack<Node> childS = new Stack<>();

        mainS.push(node);
        int level = 1;
        while (mainS.size() > 0) {

            while (mainS.size() > 0) {
                // RP
                Node rem = mainS.pop();
                System.out.print(rem.data + " ");
                if (level % 2 == 1) {
                    // add from left to rigth
                    childS.addAll(rem.children);
                } else {
                    // add from right to left
                    for (int i = rem.children.size() - 1; i >= 0; i--) {
                        childS.push(rem.children.get(i));
                    }
                }
            }
            // at this point i processed 1 particular level
            level++;
            System.out.println();
            // swap main and child
            Stack<Node> temp = mainS;
            mainS = childS;
            childS = temp;
        }
    }

    // using single loop
    public static void levelOrderLinewiseZZOhterway(Node node) {
        // write your code here

        // we will use 2 stack
        // for odd level add child from left to right
        // for even level add child from right to left

        Stack<Node> mainS = new Stack<>();
        Stack<Node> childS = new Stack<>();

        mainS.push(node);
        int level = 1;
        while (mainS.size() > 0) { // once swaped we check if main is empty/?

            // RP
            Node rem = mainS.pop();
            System.out.print(rem.data + " ");

            if (level % 2 == 1) {
                // for odd level- add left to right
                childS.addAll(rem.children);
            } else {

                // for even level - add right to left
                for (int i = rem.children.size() - 1; i >= 0; i--) {
                    childS.add(rem.children.get(i));
                }
            }

            // if mainstack becomes empty then increase level and swap main and child
            if (mainS.isEmpty()) {
                level++;
                System.out.println();
                Stack<Node> temp = mainS;
                mainS = childS;
                childS = temp;
            }
        }
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
        levelOrderLinewiseZZ(root);
        levelOrderLinewiseZZOhterway(root);
    }

}