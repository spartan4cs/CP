import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/daily-temperatures/submissions/
 */
public class Leet_DailyTemperature {

    public static int[] dailyTemperatures(int[] arr) {
        int n = arr.length;

        int temp[] = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(n - 1);
        temp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {

            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.empty()) {
                temp[i] = 0;
            } else {
                temp[i] = st.peek() - i;
            }
            st.push(i);
        }

        // for (int i = 0; i < temp.length; i++) {
        // System.out.println(temp[i]);
        // }
        return temp;
    }

    public static void main(String[] args) {

        int num[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
        dailyTemperatures(num);

        // output ; [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
