import java.util.*;

/**
 * https://leetcode.com/problems/sliding-window-maximum/submissions/
 */

class Leet_Sliding_Window_Maximum {

    public static int[] ngetr(int[] arr) {
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();

        nge[n - 1] = n;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()])
                st.pop();
            nge[i] = st.empty() ? n : st.peek();
            st.push(i);
        }

        return nge;

    }

    public static int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;
        int nge[] = new int[n];
        nge = ngetr(arr);
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int j = i;

            while (nge[j] < i + k) {
                j = nge[j];

                // edge case for last element when nge just to last elemetn
                if (j == n)
                    break;
            }

            ans[i] = arr[j];
            // System.out.println(arr[j]);
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        maxSlidingWindow(arr, k);
    }
}