import java.util.Arrays;

class TopicSortSearchTimeComplexity {

    // poly1 = f(x,n) = 1.x^n + 2.x^n-1 + 3.x^n-2 + ... + n.x^1
    // think from back
    public static int poly1(int x, int N) {

        int xval = x;
        int sum = 0;
        for (int n = N; n >= 1; n--) {

            sum += n * xval;
            xval = xval * x;
        }

        return sum;
    }

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

    public static void sort012(int[] arr) {

        int i = 0; // first unsolved
        int j = 0; // first 1
        int k = arr.length - 1; // last unsolved
        while (i <= k) { // till last unsolved

            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;

            } else if (arr[i] == 1) {

                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, k);

                k--;
            }
        }

    }

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

    public static int[] mergeTwoSortedArraysinSingleWhile(int[] a, int[] b) {
        // write your code here

        int alen = a.length;
        int blen = b.length;
        int[] ans = new int[alen + blen];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < alen || j < blen) {
            int ival = i < alen ? a[i] : Integer.MAX_VALUE;
            int jval = j < blen ? b[j] : Integer.MAX_VALUE;
            if (ival < jval) {
                ans[k] = ival;
                i++;
            } else {

                ans[k] = jval;
                j++;
            }
            k++;
        }

        return ans;

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

    public static void sort() {
        int[] arr = { 0, 1, 0, 1, 0 };
        int[] arr1 = { 0, 1, 0, 1, 0, 2, 1, 0 };

        int[] a = { 1, 4, 7 };
        int[] b = { 2, 5, 7 };
        sort01(arr);
        sort012(arr1);
        int ans[] = mergeTwoSortedArrays(a, b);
        display(ans);
        ans = mergeTwoSortedArraysinSingleWhile(a, b);
        display(ans);
        display(arr);
        display(arr1);

    }

    public static void sorting() {

        sort();
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