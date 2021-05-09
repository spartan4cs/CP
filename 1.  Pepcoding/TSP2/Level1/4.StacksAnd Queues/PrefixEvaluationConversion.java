import java.util.Stack;

public class PrefixEvaluationConversion {
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

    private static void solve(Stack<Integer> res, char ch) {
        int val1 = res.pop();
        int val2 = res.pop();
        int val = operation(ch, val1, val2);
        res.push(val);
    }

    private static void postExpression(Stack<String> res, char ch) {
        String val1 = res.pop();
        String val2 = res.pop();
        String val = val1 + val2 + ch;
        res.push(val);
    }

    private static void inExpression(Stack<String> res, char ch) {
        String val1 = res.pop();
        String val2 = res.pop();
        String val = "(" + val1 + ch + val2 + ")";
        res.push(val);
    }

    public static void preEvaluate(String str) {

        int n = str.length();
        Stack<Integer> res = new Stack<>();

        // start from back
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                res.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                solve(res, ch);
            }
        }
        System.out.println(res.peek());
    }

    public static void preToIn(String str) {

        int n = str.length();
        Stack<String> instack = new Stack<>();

        // start from back
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                instack.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                inExpression(instack, ch);
            }
        }
        System.out.println(instack.peek());
    }

    public static void preToPost(String str) {

        int n = str.length();
        Stack<String> poststack = new Stack<>();

        // start from back
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                poststack.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                postExpression(poststack, ch);
            }
        }
        System.out.println(poststack.peek());
    }

    // Sample Output
    // 2
    // ((2+((6*4)/8))-3)
    // 264*8/+3-
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String exp = br.readLine();

        String exp = "-+2/*6483";

        preEvaluate(exp);
        preToIn(exp);
        preToPost(exp);
    }
}
