
import java.io.*;
import java.util.*;

public class LinearizeGT {
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
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        Stack<Node> cstack = new Stack<>();
        int level = 0;

        while (stack.size() > 0) {
            node = stack.pop();
            System.out.print(node.data + " ");

            if (level % 2 == 0) {
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    cstack.push(child);
                }
            } else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    Node child = node.children.get(i);
                    cstack.push(child);
                }
            }

            if (stack.size() == 0) {
                stack = cstack;
                cstack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(i);
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }
    }

    public static Node getTail(Node node) {

        Node tail = node;

        while (tail.children.size() != 0) {
            tail = tail.children.get(0);
        }
        return tail;
    }

    // Approach 1 O(n^2)
    public static void linearize(Node node) {
        // write your code here
        //
        for (Node child : node.children) {
            linearize(child);
        }
        // on post order
        // and doing form back because
        // it wil not give concurrent modification exception

        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node last = node.children.get(i + 1); // getlast
            Node slast = node.children.get(i); // get secont last

            node.children.remove(i + 1);// remove last

            Node tail = getTail(slast);// gettail from 2nd last
            tail.children.add(last); // attach last to 2nd last
        }
    }

    // Approach 2
    // linearize with tail
    public static Node linearize2(Node node) {

        if (node.children.size() == 0) {
            return node;
        }

        // this call is for 1 edge
        Node lastTail = linearize2(node.children.get(node.children.size() - 1));
        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node last = node.children.remove(i + 1);
            // this call is for remaining edge
            Node slastTail = linearize2(node.children.get(i));
            slastTail.children.add(last);
        }
        return lastTail;
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
        linearize(root);
        display(root);
    }

}