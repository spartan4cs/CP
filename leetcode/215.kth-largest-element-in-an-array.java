import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {

        // maintain priority queue for k size
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {

            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.peek();
    }
}
// @lc code=end
