import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NGETL {

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }

    // Next Greater Element To The Right
    // i/p--> 5 3 8 -2 7
    // o/p--> -1 5 -1 8 8
    public static int[] solve(int[] arr) {
        // solve

        int n = arr.length;

        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        nge[0] = -1;
        st.push(0);
        for (int i = 1; i < arr.length; i++) {

            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                nge[i] = -1;
            } else {
                nge[i] = arr[st.peek()];
            }

            st.push(i);
        }
        return nge;
    }
}
