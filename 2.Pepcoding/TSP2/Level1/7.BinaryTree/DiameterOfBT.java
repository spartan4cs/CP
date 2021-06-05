
import java.io.IOException;
import java.util.*;

class TreeNode {
    TreeNode left, right;
    int data;

    TreeNode(int d) {
        data = d;
        left = right = null;
    }

}

class BinaryTree {

    static int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        // Write your code here
        diameter = 0;
        getheight(root);
        return diameter;
    }

    private int getheight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int lh = getheight(root.left);
        int rh = getheight(root.right);

        int candidate = lh + rh + 2;
        if (candidate > diameter) {
            diameter = candidate;
        }
        int height = Math.max(lh, rh) + 1;
        return height;
    }

    public String levelOrder(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null ";
                continue;
            }

            output += String.valueOf(node.data) + " ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return output.substring(0, output.length() - 1);
    }

    void printPostorder(TreeNode node) {
        if (node == null)
            return;

        printPostorder(node.left);

        printPostorder(node.right);

        System.out.print(node.data + " ");
    }

    void printPreorder(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPostorder(node.left);

        printPostorder(node.right);

    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

}

public class DiameterOfBT {

    public static TreeNode constructor_levelOderSerailize(Integer[] arr) {
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        que.addLast(root);
        int i = 1;
        while (!que.isEmpty() && i < arr.length) {
            TreeNode nn = que.removeFirst();

            if (i < arr.length && arr[i] != null) {
                TreeNode n = new TreeNode(arr[i]);
                nn.left = n;
                que.addLast(n);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                TreeNode n = new TreeNode(arr[i]);
                nn.right = n;
                que.addLast(n);
            }
            i++;
        }

        return root;
    }

    public static Integer[] inputSplitSpace(String str) {
        String[] sArr = str.split(" ");
        Integer[] arr = new Integer[sArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        TreeNode root = constructor_levelOderSerailize(inputSplitSpace(str));
        BinaryTree bt = new BinaryTree();
        System.out.println(bt.diameterOfBinaryTree(root));
    }

}