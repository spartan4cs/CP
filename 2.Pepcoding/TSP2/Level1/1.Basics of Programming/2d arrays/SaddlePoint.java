import java.util.Scanner;

public class SaddlePoint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //
        getSaddlePrice(arr);

    }

    public static void getSaddlePrice(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            // getmin
            int min = Integer.MAX_VALUE;
            int col = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    col = j;
                }
            }
            // verify max
            int max = min;
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][col] > max) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                // System.out.println("Invalid input");
            } else {
                System.out.println(max);
                return;
            }

        }
        System.out.println("Invalid input");
    }
}
