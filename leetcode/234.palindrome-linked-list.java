/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode getMid(ListNode head) {

        ListNode f=head;
        ListNode s=head;

        while (f.next!=null && f.next.next!=null) {
            s=s.next;
            f=f.next.next;
        }
        return s;
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

    public boolean isPalindrome(ListNode head) {

        ListNode l1 = head;
        ListNode mid = getMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);

        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;

    }
}
// @lc code=end
