import java.util.Stack;

public class InfixEvaluation {

    private static void solve(Stack<Integer> operands, Stack<Character> operator) {
        char op = operator.pop();
        int val2 = operands.pop();
        int val1 = operands.pop();
        int val = operation(op, val1, val2);
        operands.push(val);
    }

    public static int precedence(char ch) {
        int f = 2;
        if (ch == '+' || ch == '-') {
            f = 1;
        } else if (ch == '*' || ch == '/') {
            f = 2;
        }
        return f;
    }

    public static int operation(char op, int val1, int val2) {

        int val = 0;
        if (op == '+') {
            val = val1 + val2;
        } else if (op == '-') {
            val = val1 - val2;
        } else if (op == '*') {
            val = val1 * val2;
        } else if (op == '/') {
            val = val1 / val2;
        }

        return val;
    }

    public static void infixEvaluate(String str) {

        int n = str.length();
        // 2 stack
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < n; i++) {

            char ch = str.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                operands.push(ch - '0'); // char to int

            } else if (ch == ')') {
                while (operator.peek() != '(') {
                    solve(operands, operator);
                }
                operator.pop(); // pop (
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)) {
                    solve(operands, operator);
                }
                operator.push(ch); // pushing itselt;
            }
        }

        // still element in operator stack
        while (operator.size() != 0) {
            solve(operands, operator);
        }

        System.out.println(operands.peek());
    }

    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String exp = br.readLine();

        String exp = "2*(3+5)";
        infixEvaluate(exp);
    }
}
