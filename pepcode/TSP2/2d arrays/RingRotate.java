import java.util.Scanner;

public class RingRotate {

    public static void ringrotate(int[][] arr, int s, int r) {

        // create 1d using 2d array and return 1d array
        int[] la = fill1Dfrom2D(arr, s);
        // rotate 1d array
        rotate1D(la, r);

        // fill 2d array using 1d array
        fill2Dfrom1D(arr, la, s);
    }

    public static void fill2Dfrom1D(int[][] arr, int[] la, int s) {
        int rmin = s - 1;
        int cmin = s - 1;
        int rmax = arr.length - s;
        int cmax = arr[0].length - s;
        int totalelements = 2 * rmax + 2 * cmax - 4;
        int newArr[] = new int[totalelements];
        int j = 0;

        // left
        for (int i = rmin; i <= rmax; i++) {
            arr[i][cmin] = la[j];
            j++;
        }
        cmin++;
        // bottom
        for (int i = cmin; i <= cmax; i++) {
            arr[rmax][i] = la[j];
            j++;
        }
        rmax--;
        // right
        for (int i = rmax; i >= rmin; i--) {
            arr[i][cmax] = la[j];
            j++;
        }
        cmax--;
        // top
        for (int i = cmax; i >= cmin; i--) {
            arr[rmin][i] = la[j];
            j++;
        }

        printArr(arr);

    }

    public static void printArr(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate1D(int[] la, int r) {
        r = r % la.length;
        if (r < 0) {
            r = r + la.length;
        }

        reverse(la, 0, la.length - r - 1);

        reverse(la, la.length - r, la.length - 1);
        reverse(la, 0, la.length - 1);
    }

    public static void reverse(int[] la, int left, int right) {
        while (left < right) {

            int temp = la[left];
            la[left] = la[right];
            la[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] fill1Dfrom2D(int[][] arr, int s) {
        int rmin = s - 1;
        int cmin = s - 1;
        int rmax = arr.length - s;
        int cmax = arr[0].length - s;
        int totalelements = 2 * (rmax - rmin + cmax - cmin);
        int newArr[] = new int[totalelements];
        int j = 0;

        // left
        for (int i = rmin; i <= rmax; i++) {
            newArr[j] = arr[i][cmin];
            j++;
        }
        cmin++;
        // bottom
        for (int i = cmin; i <= cmax; i++) {
            newArr[j] = arr[rmax][i];
            j++;
        }
        rmax--;
        // right
        for (int i = rmax; i >= rmin; i--) {
            newArr[j] = arr[i][cmax];
            j++;
        }
        cmax--;
        // top
        for (int i = cmax; i >= cmin; i--) {
            newArr[j] = arr[rmin][i];
            j++;
        }

        return newArr;
    }

    public static void main(String[] args) {

        /*
         * int arr[][] = { { 1, 2, 3, 4, 5, 11, 31 }, { 6, 7, 8, 9, 10, 12, 32 }, { 13,
         * 14, 15, 16, 17, 18, 33 }, { 19, 20, 21, 22, 23, 24, 34 }, { 25, 26, 27, 28,
         * 29, 30, 35 }, { 36, 37, 38, 39, 40, 41, 42 } };
         * 
         * int s = 2; int r = 3;
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();

            }
        }
        int s = sc.nextInt();
        int r = sc.nextInt();

        ringrotate(arr, s, r);
    }
}
