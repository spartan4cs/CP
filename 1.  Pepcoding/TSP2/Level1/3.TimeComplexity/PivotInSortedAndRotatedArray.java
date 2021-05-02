import java.util.Scanner;

public class PivotInSortedAndRotatedArray {

    // recursive
    public static int findPivotRec(int[] arr, int lo, int hi) {
        // write your code here

        if (lo == hi)
            return arr[lo];

        int mid = lo + (hi - lo) / 2;
        int res = 0;

        if (arr[mid] < arr[hi]) {
            res = findPivotRec(arr, lo, mid);
        } else {
            res = findPivotRec(arr, mid + 1, hi);
        }

        return res;
    }

    // iterative
    public static int findPivot(int[] arr) {
        // write your code here

        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[hi]) {
                // leftside->including mid
                hi = mid;

            } else {
                // right side
                lo = mid + 1;
            }
        }
        return arr[lo];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }
}
