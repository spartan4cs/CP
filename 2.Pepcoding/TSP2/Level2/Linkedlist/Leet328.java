import java.util.Scanner;

public class Leet328 {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode oddEvenList(ListNode head) {

        ListNode itr = head;
        ListNode t1 = new ListNode(-1);// even
        ListNode even = t1;
        ListNode t2 = new ListNode(-1);// odd
        ListNode odd = t2;

        int i = 0;
        while (itr != null) {

            if (i % 2 == 0) {
                t1.next = itr;
                t1 = itr;
            } else {
                t2.next = itr;
                t2 = itr;
            }

            i++;
            itr = itr.next;
        }
        t1.next = null;
        t2.next = null;

        // even followed by odd
        t1.next = odd.next;

        return even.next;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int n = sc.nextInt();
        while (n-- > 0) {
            prev.next = new ListNode(sc.nextInt());
            prev = prev.next;
        }

        ListNode head = oddEvenList(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
