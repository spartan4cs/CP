
import java.io.*;
import java.util.*;

public class TargetSumPair {
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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        // write your code here

        // targetSum1(root, root, data);
        // targetSum2(root, data);
        targetSum3(root, data);
    }

    // Appraoch 1
    // Time nh Space h
    public static void targetSum1(Node node, Node root, int target) {

        if (node == null) {
            return;
        }
        int n1 = node.data;
        int n2 = target - n1;

        targetSum1(node.left, root, target);

        // inorder
        if (n2 > n1 && find(root, n2) == true) {
            System.out.println(n1 + " " + n2);
        }
        targetSum1(node.right, root, target);
    }

    public static boolean find(Node node, int data) {

        if (node == null)
            return false;

        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }

    // Approach 2
    // Time O(n) Space O(h)

    public static void targetSum2(Node node, int target) {

        // sort using inorder
        ArrayList<Integer> al = new ArrayList<>();
        inorderFiller(node, al);

        // use two pointer to get pair

        int l = 0;
        int r = al.size() - 1;
        while (l < r) {
            int sum = al.get(l) + al.get(r);

            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {

                System.out.println(al.get(l) + " " + al.get(r));
                l++;
                r--;
            }
        }
    }

    public static void inorderFiller(Node node, ArrayList<Integer> al) {
        if (node == null) {
            return;
        }
        inorderFiller(node.left, al);
        al.add(node.data);
        inorderFiller(node.right, al);
    }

    // Approach 3
    // TIme O(n)
    // Space O(h)
    public static void targetSum3(Node node, int target) {

        Stack<Pair> ls = new Stack<>();
        Stack<Pair> rs = new Stack<>();
        ls.push(new Pair(node, 0));
        rs.push(new Pair(node, 0));

        int l = inorderItr(ls);
        int r = revInorderItr(rs);

        while (l < r) {
            int sum = l + r;
            if (sum > target) {
                r = revInorderItr(rs);
            } else if (sum < target) {
                l = inorderItr(ls);
            } else {
                System.out.println(l + " " + r);
                l = inorderItr(ls);
                r = revInorderItr(rs);

            }
        }
    }

    public static int inorderItr(Stack<Pair> st) {

        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.state == 0) {
                // add left child
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
                p.state++;
            } else if (p.state == 1) {
                // add right child

                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
                p.state++;
                return p.node.data;
            } else {
                st.pop();
            }
        }
        return -1;
    }

    public static int revInorderItr(Stack<Pair> st) {
        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.state == 0) {
                // add right child
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
                p.state++;
            } else if (p.state == 1) {
                // add left child

                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
                p.state++;
                return p.node.data;

            } else {
                st.pop();
            }
        }
        return -1;
    }

}