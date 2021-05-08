import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {

    // [(a + b) + {(c + d) * (e / f)}] -> true
    // [(a + b) + {(c + d) * (e / f)]} -> false
    // [(a + b) + {(c + d) * (e / f)} -> false
    // ([(a + b) + {(c + d) * (e / f)}] -> false

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                boolean val = checkCorrespondingOpen(st, '(');
                if (val == false) {
                    System.out.println(false);
                    return;
                }
            } else if (ch == '}') {
                boolean val = checkCorrespondingOpen(st, '{');
                if (val == false) {
                    System.out.println(false);
                    return;
                }
            } else if (ch == ']') {
                boolean val = checkCorrespondingOpen(st, '[');
                if (val == false) {
                    System.out.println(false);
                    return;
                }
            }
        }
        if (st.empty()) {

            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static boolean checkCorrespondingOpen(Stack<Character> st, char ch) {
        boolean flag = false;
        if (st.size() > 0 && st.peek() == ch) {
            flag = true;
            st.pop();
        }

        return flag;
    }

}
