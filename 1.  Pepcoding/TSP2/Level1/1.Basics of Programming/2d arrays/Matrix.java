import java.util.Scanner;

public class Matrix {
    public static void multiply(int[][] arr1, int[][] arr2, int n1, int m1, int n2, int m2) {
        int arr3[][] = new int[n1][m2];
        int sum = 0;
        for (int i = 0; i < arr3.length; i++) {

            for (int j = 0; j < arr3[0].length; j++) {
                sum = 0;
                for (int k = 0; k < m1; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                arr3[i][j] = sum;

            }
        }
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[0].length; j++) {

                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int m1 = sc.nextInt();
        int[][] arr1 = new int[n1][m1];
        for (int r = 0; r < n1; r++) {
            for (int c = 0; c < m1; c++) {
                arr1[r][c] = sc.nextInt();
            }
        }

        int n2 = sc.nextInt();
        int m2 = sc.nextInt();
        int[][] arr2 = new int[n2][m2];

        for (int r = 0; r < n2; r++) {
            for (int c = 0; c < m2; c++) {
                arr2[r][c] = sc.nextInt();
            }
        }
        if (m1 == n2) {
            multiply(arr1, arr2, n1, m1, n2, m2);
        } else {
            System.out.print("Invalid input");
        }

    }
}
