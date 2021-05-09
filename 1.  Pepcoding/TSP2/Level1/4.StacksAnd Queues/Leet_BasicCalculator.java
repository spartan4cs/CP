import java.util.Stack;

public class Leet_BasicCalculator {

    // 2+(1+(4+5)+3)+(6+8)
    // sum
    // stack
    public static int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        int sign = 1; // 1 or -1
        for (int i = 0; i < n; i++) {


            // number
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // single digit(1) or multiple digit(433)
                int num = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                // calculate sum while traversing xxx +15 or xxx+(-1)*15
                sum = sum + num * sign;
                i--;

            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                // move sum and sign on to stack
                st.push(sum);
                st.push(sign);// will be used when poping and evaluating

                // reset sum and sign
                sum = 0;
                sign = 1;

            } else if (s.charAt(i) == ')') {
                // pop sign
                sum = st.pop() * sum;
                // evaluate next pop
                sum = sum + st.pop();

            }

        }
        return sum;
    }

    public static void main(String[] args) {

        String s = "1 + 1";
        System.out.println(calculate(s));
    }
}
