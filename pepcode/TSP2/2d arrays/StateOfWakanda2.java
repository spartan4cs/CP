import java.util.Scanner;

class StateOfWakanda2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // from middle diagonal to last upper diagonal
        for (int diag = 0; diag < n; diag++) {

            int i = 0;
            int j = diag;
            while (j < n) {

                System.out.println(arr[i][j]);

                i++;
                j++;
            }
        }

        // from lower diagonal to upper diagonal
        lowerToUpperDiagonal(arr);

        // zigzag diagonal ffrom lower to upper

        zigzagDiagonal(arr);
    }

    public static void zigzagDiagonal(int[][] arr) {

        
    }

    public static void lowerToUpperDiagonal(int[][] arr) {

        int n = arr.length;

        // 1st half;
        for (int diag = n - 1; diag >= 1; diag--) {
            int i = diag;
            int j = 0;
            while (i <= n - 1) {
                System.out.println(arr[i][j]);
                i++;
                j++;
            }
        }
        // half
        for (int diag = 0; diag <= n - 1; diag++) {
            int i = 0;
            int j = diag;
            while (j <= n - 1) {
                System.out.println(arr[i][j]);
                i++;
                j++;
            }
        }
    }
}