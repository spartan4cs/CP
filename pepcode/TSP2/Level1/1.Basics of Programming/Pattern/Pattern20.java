import java.util.Scanner;

public class Pattern20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= n / 2) {
                    if (j == i || j + i == n - 1) {
                        System.out.print("*\t");
                    } else if (i != n - 1 && (j == 0 || j == n - 1)) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else {
                    if ((j == 0 || j == n - 1)) {
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
