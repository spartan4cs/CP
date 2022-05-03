import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        // write your code here
        if (minRemoval == 0) {// last level

            if (getMin(str) == 0) {// to check valid

                if (!ans.contains(str)) { // to cehck duplicacy
                    System.out.println(str);
                    ans.add(str);
                }

            }
            return;

        }

        for (int i = 0; i < str.length(); i++) {
            // char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);

            solution(left + right, minRemoval - 1, ans);
        }
    }

    public static int getMin(String str) {
        // write your code here
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.isEmpty() || st.peek() == ')') {
                    st.push(ch);

                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str), new HashSet<>());
    }
}
