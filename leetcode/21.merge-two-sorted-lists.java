/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                prev.next = list1;
                prev = prev.next;
                list1 = list1.next;
            } else {

                prev.next = list2;
                prev = prev.next;
                list2 = list2.next;
            }

        }
        if (list1 == null) {
            prev.next = list2;
        }

        if (list2 == null) {
            prev.next = list1;
        }
        return head.next;
    }

    // using recursion

    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    */
}
// @lc code=end
