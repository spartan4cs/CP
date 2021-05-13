import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumStackConstantSpace {

    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            // write your code here

            return data.size();
        }

        void push(int val) {
            // write your code here
            if (data.empty()) {
                data.push(val);
                min = val;
            } else if (val < min) {
                // toh min ko update karna he with val
                data.push(val + val - min);// fake value store
                min = val;
            } else {
                data.push(val);

            }
        }

        int pop() {
            if (data.empty()) {
                System.out.println("Stack underflow");
                return -1;
            } else
            // write your code here
            if (data.peek() < min) {
                // update min back
                int val = min;
                min = 2 * min - data.pop();
                return val;
            } else {
                return data.pop();
            }
        }

        int top() {
            if (data.empty()) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                // write your code here
                if (data.peek() < min) {
                    return min;
                } else {
                    return data.peek();
                }

            }

        }

        int min() {
            // write your code here

            if (data.empty()) {
                System.out.println("Stack underflow");
                return -1;
            } else
                return min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
