import java.util.Scanner;
import java.util.Stack;

class Next_Greater_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int arr[] = new int[t];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
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

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
            if (i != ans.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}