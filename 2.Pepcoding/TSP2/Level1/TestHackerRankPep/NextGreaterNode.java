import java.util.Scanner;
import java.util.Stack;

public class NextGreaterNode {
    public static class Node {
        int data;
        Node next;

        Node() {

        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static int[] nextGreaterNode(Node head) {
        /* write your code here */

        Node itr = head;
        int size = 0;
        while (itr != null) {
            size++;
            itr = itr.next;
        }
        itr = head;
        int[] arr = new int[size];
        int j = 0;
        while (itr != null) {
            arr[j] = itr.data;
            itr = itr.next;
            j++;
        }
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[size];
        st.push(size - 1);
        ans[size - 1] = 0;
        for (int i = size - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            ans[i] = st.empty() ? 0 : arr[st.peek()];

            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            Node node = new Node(val, null);

            if (i == 0) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        int[] ans = nextGreaterNode(head);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
