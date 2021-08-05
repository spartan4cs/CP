import java.util.Scanner;

public class RemoveNthNodeFromEndOfLink_Leet19 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int getSize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        if (n == getSize(head)) {
            head = head.next;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;

        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        int m = scn.nextInt();
        h1 = removeNthFromEnd(h1, m);
        printList(h1);
    }
}
