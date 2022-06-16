import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else
                    return false;
            } else if (ch == ']') {
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                } else
                    return false;
            } else if (ch == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else
                    return false;
            }

        }

        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}
// @lc code=end
