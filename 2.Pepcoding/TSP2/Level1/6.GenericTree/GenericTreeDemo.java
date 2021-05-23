import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GenericTreeDemo {

    public static class Node {
        int data;
        List<Node> children;

        public Node() {
            this.data = 0;
            this.children = new ArrayList<>();

        }

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();

        }
    }
    // 10, 20, null, 30, 50, null, 60, null, null, 40, null, null

    public static Node construction(Integer[] arr) {

        Node root = null;
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            Integer data = arr[i];
            if (data != null) {
                Node temp = new Node(data);

                if (st.size() == 0) {
                    root = temp;
                } else {
                    st.peek().children.add(temp);
                }

                st.push(temp);
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node root) {

        // no base case need as smart call are done

        // print root node and children start
        String str = "[" + root.data + "] -> ";
        for (Node child : root.children) {
            str += child.data + ",";
        }
        System.out.println(str + " .");
        // print currnt node and children end

        // making call to next level for children
        for (int i = 0; i < root.children.size(); i++) {
            display(root.children.get(i));
        }

    }

    // depth traversal using stack

    public static void displayusingstack(Node root) {

        Stack<Node> st = new Stack<>();

        st.push(root);
        while (st.size() > 0) {
            // RPA
            Node rem = st.pop();
            System.out.print(rem.data + " ");
            for (Node child : rem.children) {
                st.push(child);
            }
        }
    }

    public static void fun() {

        Integer[] arr = { 10, 20, null, 30, 50, null, 60, null, null, 40, null, null };

        Node res = construction(arr);
        display(res);

    }

    public static void main(String[] args) {

        fun();
    }
}