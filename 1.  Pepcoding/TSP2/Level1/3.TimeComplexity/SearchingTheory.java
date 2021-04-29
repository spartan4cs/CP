import java.util.Arrays;

class SearchingTheory {

    public static int linearSearch(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (data == i)
                return i;

        }
        return -1;
    }

    public static boolean binarySearchRec(int[] arr, int lo, int hi, int data) {

        // base case
        if (lo > hi)
            return false;
        boolean res = false;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == data) {
            res = true;

        } else if (data < arr[mid]) {
            res = binarySearchRec(arr, lo, mid - 1, data);
        } else if (data > arr[mid]) {
            res = binarySearchRec(arr, mid + 1, hi, data);
        }
        return res;
    }

    public static int binarySearchRecIndx(int[] arr, int lo, int hi, int data) {

        // base case
        if (lo > hi)
            return -1;
        int res = -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == data) {
            res = mid;

        } else if (data < arr[mid]) {
            res = binarySearchRecIndx(arr, lo, mid - 1, data);
        } else if (data > arr[mid]) {
            res = binarySearchRecIndx(arr, mid + 1, hi, data);
        }
        return res;
    }

    public static void sort01(int[] arr) {
        // write your code here

        int i = 0; // unsolved
        int j = 0; // first one1
        while (i < arr.length) {
            if (arr[i] == 0) {

                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void searching() {

        int[] p = { 1, 3, 4, 5, 6, 7, 8, 15, 22 };
        int data = 3;
        int indx = linearSearch(p, data);
        boolean elementPresent = binarySearchRec(p, 0, p.length - 1, data);
        int binaryIndex = binarySearchRecIndx(p, 0, p.length - 1, data);
        System.out.println(binaryIndex);
        System.out.println(elementPresent);
        System.out.println(data + " found at " + indx + " index");
        display(p);
    }

    public static void sort1() {
        int[] arr = { 0, 1, 0, 1, 0 };

        sort01(arr);
        display(arr);
    }

    public static void sorting() {

        sort1();
    }

    public static void ques() {
        searching();
        sorting();
    }

    public static void main(String[] args) {
        ques();
    }

    public static void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}