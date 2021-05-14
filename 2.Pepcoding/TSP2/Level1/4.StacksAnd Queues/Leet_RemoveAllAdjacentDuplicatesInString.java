import java.util.Stack;

public class Leet_RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        st.push(0);

        // aaaaabbbcccccaaab
        // aaa
        for (int i = 1; i < n; i++) {
            if (st.size() > 0 && s.charAt(i) == s.charAt(st.peek()))
                st.pop();

            else {
                st.push(i);

            }
        }

        StringBuilder sb = new StringBuilder();

        while (st.size() > 0) {
            sb.insert(0, c[st.pop()]);
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        String s = "aa";
        System.out.println(removeDuplicates(s));
    }
}
