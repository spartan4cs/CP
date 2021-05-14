import java.util.Stack;

/***
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * if ( then push else pop and get max (ans,i-st.peek)
 * 
 * in case when we get closing at the start then initially we stoer in stack as
 * -a -1 and check if stack empty then push current index
 */
public class Leet_Longest_Valid_Parentheses {
    public static int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {

                st.pop();
                if (st.empty()) {
                    st.push(i); // put current index
                } else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = ")))(()";
        System.out.println(longestValidParentheses(s));
    }
}
