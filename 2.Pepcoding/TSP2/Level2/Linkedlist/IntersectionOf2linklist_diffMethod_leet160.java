import java.util.Scanner;

public class IntersectionOf2linklist_diffMethod_leet160 {
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
        int s = 0;
        while (temp != null) {

            temp = temp.next;
            s++;
        }
        return s;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {

        int s1 = getSize(headA);
        int s2 = getSize(headB);
        ListNode t1 = headA;
        ListNode t2 = headB;
        if (s1 > s2) {
            for (int i = 0; i < s1 - s2; i++) {
                t1 = t1.next;
            }
        } else {
            for (int i = 0; i < s2 - s1; i++) {
                t2 = t2.next;
            }
        }

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1 != null ? t1 : null;
    }

    // Input_code===================================================

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}
