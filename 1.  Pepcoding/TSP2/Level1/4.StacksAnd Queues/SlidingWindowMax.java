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

        // nge to right

        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();

        nge[n - 1] = n;
        st.push(0);

        for (int i = n - 2; i >= 0; i--) {

            while (st.size() > 0 && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                nge[i] = n;

            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        // code

        for (int i = 0; i < a.length - k; i++) {

            int j = i;

            while (j < i + k) {
                j = nge[j];
            }
            System.out.println(a[j]);
        }
    }
}
