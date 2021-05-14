import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class Leet_Next_Greater_Element_II {
    public static int[] nextGreaterElements(int[] arr) {

        int n = arr.length;

        // nge to right
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();

        // setting stack
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            st.push(i);
        }

        // starting again from right to left
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            ans[i] = st.empty() ? -1 : arr[st.peek()];

            st.push(i);
        }

        // for (int i : ans) {
        // System.out.println(i);
        // }
        return ans;

    }

    public static void main(String[] args) {

        // Input: nums = [1,2,3,4,3]
        // Output: [2,3,4,-1,4]

        int num[] = { 1, 2, 3, 4, 3 };
        nextGreaterElements(num);
    }
}
