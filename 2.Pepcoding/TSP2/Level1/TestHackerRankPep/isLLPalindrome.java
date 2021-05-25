import java.util.Scanner;

public class isLLPalindrome {
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

    public static Node getMid(Node head) {

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static Node reverseLL(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head) {
        /* write your code here */

        Node head1 = head;
        Node temp = head;
        Node mid = getMid(temp);
        Node head2 = mid.next;
        mid.next = null;
        head2 = reverseLL(head2);

        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
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

        System.out.println(isPalindrome(head));
    }
}
