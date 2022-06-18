/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    // approach 1
    // get lenA-lenB and move largest list to that differernce

    public int size(ListNode head) {

        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;

    }

    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    // int lenA = size(headA);
    // int lenB = size(headB);
    // int diff = Math.abs(lenA - lenB);
    // int temp = diff;
    // if (lenA > lenB) {
    // while (temp-- > 0) {
    // headA = headA.next;
    // }
    // } else {

    // while (temp-- > 0) {
    // headB = headB.next;
    // }
    // }

    // while (headA != headB) {
    // headA = headA.next;
    // headB = headB.next;

    // }
    // return headA;
    // }

    // approach 2

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // boundary check
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        // if a & b have different len, then we will stop the loop after second
        // iteration
        while (a != b) {
            // for the end of first iteration, we just reset the pointer to the head of
            // another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;

    }
}
// @lc code=end
