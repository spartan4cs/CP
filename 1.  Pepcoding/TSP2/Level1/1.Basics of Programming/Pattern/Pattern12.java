import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int stars = 1;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < stars; j++) {
                System.out.print(fib(counter) + "\t");
                counter++;
            }
            stars++;
            System.out.println();
        }

    }

    public static int fib(int n) {
        int[] f = new int[n + 2];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];

    }
}
