import java.util.Scanner;

class CycleNodeInLinkList_Leet_142 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode CycleNode(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {// meeting point
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static ListNode takeInput() {
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (n-- > 0) {
            temp.next = new ListNode(scn.nextInt());
            temp = temp.next;
        }
        int idx = scn.nextInt();
        if (idx >= 0) {
            ListNode curr = dummy.next;
            while (idx-- > 0) {
                curr = curr.next;
            }
            temp.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = takeInput();
        ListNode ans = CycleNode(head);
        System.out.println(ans != null ? ans.val : -1);
    }
}