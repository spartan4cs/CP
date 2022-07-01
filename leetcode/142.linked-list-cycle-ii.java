/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        

            
//   https://www.youtube.com/watch?v=dpqpgnTHiLs]
    //slow will not complete cycle and fast will complete cycle and catch slow at the metting point
    //this is true for case where ratiio of fast and slow =2 and for the remaining it may happen that slow completes the cycle
        
        ListNode slow= head;
        ListNode fast= head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                while(head!=slow){
                    head=head.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
// @lc code=end

