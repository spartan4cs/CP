import java.util.Stack;

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
        return temp;
    }

    public static void main(String[] args) {

    }
}
