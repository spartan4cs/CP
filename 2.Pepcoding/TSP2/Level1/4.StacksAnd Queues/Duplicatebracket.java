import java.util.Scanner;
import java.util.Stack;

public class Duplicatebracket {

    // ((a + b) + (c + d)) -> false
    // (a + b) + ((c + d)) -> true

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {

                if (st.peek() == '(') {
                    System.out.println(true);
                    return;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }

        }
        System.out.println(false);
    }
}
