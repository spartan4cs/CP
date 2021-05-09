import java.io.*;
import java.util.Stack;

public class SlidingWindowMax {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());

        // int a[] = { 2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6 };
        // int n = a.length;
        // int k = 4;
        // nge to right

        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();

        nge[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && a[i] >= a[st.peek()])
                st.pop();

            nge[i] = st.empty() ? n : st.peek(); // storing index as we are refereing for nge jumping
            st.push(i);
        }

        // code

        for (int i = 0; i <= n - k; i++) {

            int j = i;

            while (nge[j] < i + k) {
                j = nge[j];
            }
            System.out.println(a[j]);
        }
    }
}
