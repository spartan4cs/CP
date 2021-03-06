import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // code

        // nsetl
        int[] lb = new int[n];
        Stack<Integer> st1 = new Stack<>();

        lb[0] = -1;
        st1.push(0);
        for (int i = 1; i < n; i++) {

            while (st1.size() > 0 && a[i] <= a[st1.peek()]) {
                st1.pop();
            }

            if (st1.empty()) {
                lb[i] = -1;
            } else {
                lb[i] = st1.peek();
            }

            st1.push(i);
        }

        // nsetr
        int[] rb = new int[n];
        Stack<Integer> st2 = new Stack<>();

        rb[n - 1] = n;
        st2.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {

            while (st2.size() > 0 && a[i] <= a[st2.peek()]) {
                st2.pop();
            }

            if (st2.empty()) {
                rb[i] = n;
            } else {
                rb[i] = st2.peek();
            }

            st2.push(i);
        }

     
        // get max area using rb and lb
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * a[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }
}
