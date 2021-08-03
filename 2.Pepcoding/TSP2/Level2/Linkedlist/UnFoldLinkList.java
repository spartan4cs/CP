import java.util.Scanner;

public class UnFoldLinkList {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    public static void unfold(ListNode head) {

        ListNode oh = new ListNode(-1);
        ListNode eh = new ListNode(-1);
        ListNode t1 = oh;
        ListNode t2 = eh;

        int indx = 0;
        for (ListNode i = head; i != null; i = i.next, indx++) {
            if (indx % 2 == 1) {
                t1.next = i;
                t1 = i;
            } else {
                t2.next = i;
                t2 = i;
            }
        }
        t1.next = null;
        t2.next = null;

        oh = reverse(oh.next);
        t2.next = oh;

    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
