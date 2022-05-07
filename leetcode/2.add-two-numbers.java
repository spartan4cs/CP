/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode ans1 = ans;
        int cf = 0;
        while (l1 != null && l2 != null) {
            int n1 = l1.val;
            int n2 = l2.val;
            int sum = n1 + n2 + cf;
            if (sum >= 10) {
                int temp = sum;
                sum = sum % 10;
                cf = temp / 10;

            } else {
                cf = 0;
            }
            ans.next = new ListNode(sum);
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int n1 = l1.val;
            int sum = n1 + cf;
            if (sum >= 10) {
                int temp = sum;
                sum = sum % 10;
                cf = temp / 10;

            } else {
                cf = 0;
            }
            ans.next = new ListNode(sum);
            ans = ans.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int n2 = l2.val;
            int sum = n2 + cf;
            if (sum >= 10) {
                int temp = sum;
                sum = sum % 10;
                cf = temp / 10;

            } else {
                cf = 0;
            }
            ans.next = new ListNode(sum);
            ans = ans.next;
            l2 = l2.next;
        }

        if (cf>0) {
            ans.next = new ListNode(cf);

        }
        return ans1.next;
    }
}
// @lc code=end
