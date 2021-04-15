import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j <= n / 2 || j == n - 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if (i < n / 2) {
                    if (j == n / 2 || j == n - 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if (i == n / 2) {
                    System.out.print("*\t");
                } else if (i < n - 1) {
                    if (j == n / 2 || j == 0) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if (i == n - 1) {
                    if (j >= n / 2 || j == 0) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }
}
