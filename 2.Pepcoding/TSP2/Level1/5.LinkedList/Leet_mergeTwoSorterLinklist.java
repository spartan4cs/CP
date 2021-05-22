public class Leet_mergeTwoSorterLinklist {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;

            } else {
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }

        }
        // t1 empty
        if (t1 == null) {
            temp.next = t2;
        }
        // tr2 empty
        else if (t2 == null) {
            temp.next = t1;
        }

        return dummy.next;

    }

    public static void main(String[] args) {

    }
}
