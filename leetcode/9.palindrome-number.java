/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {

        Queue<Integer> q = new LinkedList<>();
        int temp = x;
        while (temp > 0) {
            q.offer(temp % 10);
            temp = temp / 10;
        }
        int n = 0;
        while (!q.isEmpty()) {
            n = n * 10 + q.poll();
        }
        if (x == n) {
            return true;
        }
        return false;
    }
}
// @lc code=end
