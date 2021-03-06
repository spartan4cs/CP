import java.util.Scanner;

public class Odd_Even_Linked_List_Leet328 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode itr = head;
        ListNode t1 = new ListNode(-1);// even
        ListNode evenhead = t1;
        ListNode t2 = new ListNode(-1);// odd
        ListNode oddhead = t2;

        while (itr != null) {
            if (itr.val % 2 == 0) {
                t1.next = itr;
                t1 = itr;

            } else {
                t2.next = itr;
                t2 = itr;

            }
            itr = itr.next;
        }
        t1.next = null;
        t2.next = null;

        t1.next = oddhead.next;

        return evenhead.next;

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

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
