import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NGETR {

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
    // o/p--> 8 8 -1 7 -1
    public static int[] solve(int[] arr) {
        // solve

        Stack<Integer> st = new Stack<>();
        int nge[] = new int[arr.length];
        nge[arr.length - 1] = -1;
        st.push(arr.length - 1); // 1st index
        for (int i = arr.length - 2; i >= 0; i--) {

            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }

            if (st.size() > 0) {
                nge[i] = arr[st.peek()];
            } else {
                nge[i] = -1;
            }

            st.push(i);
        }
        return nge;
    }
}
