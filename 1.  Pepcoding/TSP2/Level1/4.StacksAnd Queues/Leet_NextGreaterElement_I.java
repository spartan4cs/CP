import java.util.Scanner;
import java.util.Stack;

class Leet_NextGreaterElement_I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // nge for nums2
        int n2 = nums2.length;
        int n1 = nums1.length;

        int nge2[] = new int[n2];
        Stack<Integer> st = new Stack<>();
        st.push(n2 - 1);
        nge2[n2 - 1] = -1;
        for (int i = n2 - 2; i >= 0; i--) {

            while (st.size() > 0 && nums2[i] > nums2[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                nge2[i] = -1;
            } else {
                nge2[i] = nums2[st.peek()];
            }
            st.push(i);
        }

        // maintain hash for nums2 and its index index
        int heap[] = new int[10001];
        for (int i = 0; i < n2; i++) {
            heap[nums2[i]] = i;
        }
        // for num1 get nge2
        int ans[] = new int[n1];

        for (int i = 0; i < n1; i++) {
            int pos = heap[nums1[i]];
            ans[i] = nge2[pos];
             System.out.println(ans[i]);
        }

        return ans;

    }

    public static void main(String[] args) {

        int[] num1 = { 4, 1, 2 };
        int[] num2 = { 1, 3, 4, 2 };
        nextGreaterElement(num1, num2);
    }
}