import java.util.Scanner;

public class MergeSort {

    public static int[] mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            int[] bres = new int[1];
            bres[0] = arr[lo];
            return bres;
        }
        int mid = lo + (hi - lo) / 2;

        int arr1[] = mergeSort(arr, lo, mid);
        int arr2[] = mergeSort(arr, mid + 1, hi);
        int res[] = mergeTwoSortedArrays(arr1, arr2);

        return res;
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {

        int s1 = arr1.length;
        int s2 = arr2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int res[] = new int[s1 + s2];
        while (i < s1 || j < s2) {

            int ival = i < s1 ? arr1[i] : Integer.MAX_VALUE;
            int jval = j < s2 ? arr2[j] : Integer.MAX_VALUE;

            if (ival < jval) {
                res[k] = ival;
                i++;
            } else {

                res[k] = jval;
                j++;
            }
            k++;
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }

        int[] mergeSort = new int[n];
        mergeSort = mergeSort(arr, 0, arr.length - 1);
        for (int i : mergeSort) {
            System.out.println(i);
        }

    }
}
