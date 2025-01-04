import java.util.Stack;

class BinaryTreeConstruction {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;

        }

    }

    public static Node construct(Integer[] arr) {

        // push root node
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        int idx = 0;
        while (st.size() > 0) {
            Pair p = st.peek();

            // 3 states to be managed
            if (p.state == 0) {

                // attach to left & push
                idx++;
                if (arr[idx] != null) {
                    Node nn = new Node(arr[idx]);
                    p.node.left = nn;
                    st.push(new Pair(nn, 0));

                }
                p.state++;

            } else if (p.state == 1) {

                // attach to right & push
                idx++;
                if (arr[idx] != null) {
                    Node nn = new Node(arr[idx]);
                    p.node.right = nn;
                    st.push(new Pair(nn, 0));

                }
                p.state++;
            } else {
                // pop
                st.pop();
            }

        }
        return root;
    }

    public static void main(String[] args) {

        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        // printInorder(root);
        // System.out.println();
        // printPreorder(root);
        // System.out.println();
        // printPostorder(root);

        display(root);// preorder

    }

    /* Given a binary tree, print its nodes in preorder */
    static void display(Node node) {
        if (node == null)
            return;
        String str = "";
        str = node.left == null ? " ." : "" + node.left.data;
        str += " <= [" + node.data + "] => ";
        str += node.right == null ? " ." : "" + node.right.data;
        System.out.println(str);

        /* first print data of node */

        /* then recur on left sutree */
        display(node.left);

        /* now recur on right subtree */
        display(node.right);
    }

    /*
     * Given a binary tree, print its nodes according to the "bottom-up" postorder
     * traversal.
     */
    static void printPostorder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.data + " ");
    }

    /* Given a binary tree, print its nodes in inorder */
    static void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder */
    static void printPreorder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.data + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

}