import java.util.Scanner;

public class SearchIn2D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j <= n - 1) {
            if (arr[i][j] == x) {
                System.out.println(i);
                System.out.println(j);
                return;
            } else if (x > arr[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        System.out.println("Not Found");

    }

}
