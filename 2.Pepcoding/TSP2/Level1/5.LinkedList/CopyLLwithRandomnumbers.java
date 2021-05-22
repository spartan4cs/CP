
import java.util.*;

class CopyLLwithRandomnumbers {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        // write code here

        ListNode head1 = head;
        ListNode t1 = head;

        // 1. clone with random pointer
        ListNode head2 = new ListNode(-1);
        ListNode dummy = head2;
        while (t1 != null) {
            ListNode temp = new ListNode(t1.val);
            dummy.next = temp;
            dummy = temp;
            t1 = t1.next;
        }
        head2 = head2.next;
         

        // connext in zigzag order
        t1 = head;
        ListNode t2 = head2;
        while (t1 != null && t1 != null) {

            ListNode n1 = t1.next;
            ListNode n2 = t2.next;

            t1.next = t2;
            t2.next = n1;

            t1 = n1;
            t2 = n2;
        }

        // set the random pointer
        t1 = head;
        while (t1 != null) {
            t1.next.random = t1.random == null ? null : t1.random.next;
            t1 = t1.next.next;
        }

        // rearrange original list;

        ListNode d1 = new ListNode(-1);
        t1 = d1;
        ListNode d2 = new ListNode(-1);
        t2 = d2;
        ListNode temp = head;
        while (temp != null) {
            t1.next = temp;
            t2.next = temp.next;

            // update t1 t2
            t1 = t1.next;
            t2 = t2.next;

            temp = temp.next.next;
        }
        t1.next = null;
        t2.next = null;

        // return d2.head
        return d2.next;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if (idx != -1)
                arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}