/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null && head.next != null) {

            ListNode prev = head;
            ListNode curr = head.next;

            while (curr != null) {
                if (prev.val == curr.val) {
                    curr = curr.next;
                } else {
                    prev.next = curr;
                    prev = prev.next;
                    curr = curr.next;
                }
            }
            prev.next = curr;
        }
        return head;
    }

    // recursive
/*
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
*/


}
// @lc code=end
