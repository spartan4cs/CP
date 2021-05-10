import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 * 
 */
public class Leet_Simplify_Path {
    public static String simplifyPath(String path) {

        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        Stack<String> st2 = new Stack<>();

        String[] split = path.split("/");
        for (String string : split) {
            System.out.println(string);
        }
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("") || split[i].equals(".")) {
                continue;
            } else if (split[i].equals("..")) {
                if (!st.empty()) {
                    st.pop();
                } else {
                    continue;
                }
            } else {
                st.push(split[i]);
            }

        }

        while (st.size() > 0) {
            st2.push(st.pop());
        }
        if (st2.empty()) {
            sb.append("/");
        } else {
            while (st2.size() > 0) {
                sb.append("/").append(st2.pop());
            }

        }

        return sb.toString();

    }

    public static void main(String[] args) {

        String str = "/../";
        System.out.println(simplifyPath(str));
    }

}
