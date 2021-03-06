import java.util.Scanner;

public class rotate90 {

    // transpose without using extraspace

    public static void transpose(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        int b[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                b[j][i] = arr[i][j]; // transpose
            }
        }

        // column arrangement using column swaps
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int temp = b[i][l];
                b[i][l] = b[i][r];
                b[i][r] = temp;
                l++;
                r--;
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

    }

}
