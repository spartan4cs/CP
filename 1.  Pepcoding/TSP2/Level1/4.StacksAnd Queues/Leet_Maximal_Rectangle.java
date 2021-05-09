import java.util.Stack;

public class Leet_Maximal_Rectangle {

    public static int largestAreaHistogram(int a[]) {
        int n = a.length;
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
        return maxArea;
    }

    public static int maximalRectangle(char[][] matrix) {

        // [] or [[]]
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int arr[] = new int[m];
        int res = 0;
        for (int i = 0; i < n; i++) {

            // creating arr ar every iteration
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j] += matrix[i][j] - '0';
                }
            }
            res = Math.max(res, largestAreaHistogram(arr));
        }
        return res;
    }

    public static void main(String[] args) {

        char[][] mat = {

                { '1', '0', '1', '0', '0' },

                { '1', '0', '1', '1', '1' },

                { '1', '1', '1', '1', '1' },

                { '1', '0', '0', '1', '0' }

        };

        System.out.println(maximalRectangle(mat));
    }
}
