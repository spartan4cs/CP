import java.util.Scanner;

public class MergeTwoSortedArr {
    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        // write your code here

        int alen = a.length;
        int blen = b.length;
        int[] ans = new int[alen + blen];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < alen && j < blen) {
            // if below 2 while not written

            if (a[i] < b[j]) {
                ans[k] = a[i];
                i++;
            } else {

                ans[k] = b[j];
                j++;
            }
            k++;
        }
        // if i is remaining
        while (i < alen) {
            ans[k] = a[i];
            i++;
            k++;
        }
        // if j is remaining
        while (j < blen) {
            ans[k] = b[j];
            j++;
        }
        return ans;

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }

}
