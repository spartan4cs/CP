import java.util.Stack;

public class InfixConversion {
    public static int precedence(char ch) {
        int f = 2;
        if (ch == '+' || ch == '-') {
            f = 1;
        } else if (ch == '*' || ch == '/') {
            f = 2;
        }
        return f;
    }

    public static void infixConversion(String str) {

        int n = str.length();
        // 2 stack
        Stack<String> prestack = new Stack<>();
        Stack<Character> operator = new Stack<>();
        Stack<String> poststack = new Stack<>();

        for (int i = 0; i < n; i++) {

            char ch = str.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                prestack.push("" + ch);
                poststack.push("" + ch);

            } else if (ch == ')') {
                while (operator.peek() != '(') {
                    solve(prestack, poststack, operator);

                }
                operator.pop(); // pop (
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)) {
                    solve(prestack, poststack, operator);
                }
                operator.push(ch); // pushing itselt;
            }
        }

        // still element in operator stack
        while (operator.size() != 0) {
            solve(prestack, poststack, operator);
        }

        System.out.println(poststack.peek());
        System.out.println(prestack.peek());
    }

    private static void solve(Stack<String> prestack, Stack<String> poststack, Stack<Character> operator) {
        char op = operator.pop();
        String val2 = prestack.pop();
        String val1 = prestack.pop();
        // int val = operation(op, val1, val2);
        String pre = op + val1 + val2;
        prestack.push(pre);

        val2 = poststack.pop();
        val1 = poststack.pop();
        String post = val1 + val2 + op;
        poststack.push(post);
    }

    // Sample Output
    // abc-d+*e/
    // /*a+-bcd
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String exp = br.readLine();

        String exp = "a*(b-c+d)/e";
        infixConversion(exp);

    }
}
