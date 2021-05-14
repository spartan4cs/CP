import java.util.Stack;

public class PostFixEvaluationConversion {
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
        int val2 = res.pop();
        int val1 = res.pop();
        int val = operation(ch, val1, val2);
        res.push(val);
    }

    private static void preExpression(Stack<String> res, char ch) {
        String val2 = res.pop();
        String val1 = res.pop();
        String val = ch + val1 + val2;
        res.push(val);
    }

    private static void inExpression(Stack<String> res, char ch) {
        String val2 = res.pop();
        String val1 = res.pop();
        String val = "(" + val1 + ch + val2 + ")";
        res.push(val);
    }

    public static void postEvaluate(String str) {

        int n = str.length();
        Stack<Integer> res = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                res.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                solve(res, ch);
            }
        }
        System.out.println(res.peek());
    }

    public static void postToIn(String str) {

        int n = str.length();
        Stack<String> instack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                instack.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                inExpression(instack, ch);
            }
        }
        System.out.println(instack.peek());
    }

    public static void postToPre(String str) {

        int n = str.length();
        Stack<String> prestack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                prestack.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                preExpression(prestack, ch);
            }
        }
        System.out.println(prestack.peek());
    }

    // Sample Output
    // 2
    // ((2+((6*4)/8))-3)
    // -+2/*6483
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String exp = br.readLine();

        String exp = "264*8/+3-";

        postEvaluate(exp);
        postToIn(exp);
        postToPre(exp);
    }
}
