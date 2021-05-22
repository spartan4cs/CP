public class Leet_PalindromeLL {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {

        // first : move to middle
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { // slwo goes to right middle or even number
            slow = slow.next;
            fast = fast.next.next;
        }

        // if odd
        if (fast != null)
            slow = slow.next;

        // second: reverse 2nd half
        slow = reverse(slow); // at this point slow will point at head of 2nd half
        // make fast as head
        fast = head;

        // compare 1st half with 2nd
        while (slow != null) { // using slwo as it is lesser part
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String[] args) {

    }
}
