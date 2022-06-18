/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
    
        ListNode curr = head;
        ListNode p= new ListNode(0);
        ListNode plink=p;
        ListNode q= new ListNode();
        ListNode qlink = q;


        while (curr!=null) {
            if (curr.val<x) {
                p.next=curr;
                p=p.next;
                curr=curr.next;

            } else {
                q.next=curr;
                q=q.next;
                curr=curr.next;
            }
        }

        q.next=null;
        p.next=qlink.next;

        return plink.next;

    }
}
// @lc code=end

