import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumStack {

    // using single stack
    class MinStack2 {

        /** initialize your data structure here. */
        private Stack<int[]> st;

        public MinStack2() {
            st = new Stack<>();
        }

        public void push(int val) {
            // if the stack is empty, the min value should be the val itself
            if (st.isEmpty()) {
                int[] arr = new int[2];
                arr[0] = val;
                arr[1] = val;
                st.push(arr);
            }
            // now, compare the existed min val to this new added val
            else {
                int[] arr = new int[2];
                arr[0] = val;
                arr[1] = Math.min(getMin(), val);
                st.push(arr);
            }

        }

        public void pop() {
            st.pop();
        }

        public int top() {
            int[] arr = st.peek();
            return arr[0];
        }

        public int getMin() {
            // the current min value for the elements in the stacks currently
            // always store in the top element
            return st.peek()[1];
        }
    }

    // using 2 stack
    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            // write your code here
            return allData.size();
        }

        void push(int val) {
            // write your code here
            if (allData.size() == 0 || val <= minData.peek()) {
                allData.push(val);
                minData.push(val);
            } else {
                allData.push(val);
            }
        }

        int pop() {
            // write your code here
            if (allData.size() == 0) {

                System.out.println("Stack underflow");
                return -1;
            }
            int val = allData.pop();
            if (val == minData.peek())
                minData.pop();
            return val;
        }

        int top() {
            // write your code here
            if (allData.size() == 0) {

                System.out.println("Stack underflow");
                return -1;
            }
            return allData.peek();
        }

        int min() {
            // write your code here
            if (minData.size() == 0) {

                System.out.println("Stack underflow");
                return -1;
            }

            return minData.peek();
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
