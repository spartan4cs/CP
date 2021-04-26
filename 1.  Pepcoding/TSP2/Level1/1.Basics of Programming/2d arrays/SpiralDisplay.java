import java.util.*;

public class SpiralDisplay {

    public static void spiralDisplay(int arr[][]) {

        int n = arr.length;
        int m = arr[0].length;

        int rmin = 0;
        int rmax = n - 1;
        int cmin = 0;
        int cmax = m - 1;
        int totalElement = n * m;

        while (totalElement > 0) {

            // left
            for (int i = rmin; i <= rmax && totalElement > 0; i++) {
                System.out.println(arr[i][cmin]);
                totalElement--;
            }
            cmin++;

            // bottom
            for (int i = cmin; i <= cmax && totalElement > 0; i++) {
                System.out.println(arr[rmax][i]);
                totalElement--;
            }
            rmax--;

            // right
            for (int i = rmax; i >= rmin && totalElement > 0; i--) {
                System.out.println(arr[i][cmax]);
                totalElement--;
            }
            cmax--;

            // top
            for (int i = cmax; i >= cmin && totalElement > 0; i--) {
                System.out.println(arr[rmin][i]);
                totalElement--;
            }
            rmin++;

        }

    }

    public static void main(String[] args) {

        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // int arr[][] = new int[n][m];
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr[0].length; j++) {
        // arr[i][j] = sc.nextInt();
        // }
        // }
        spiralDisplay(arr);
    }
}
