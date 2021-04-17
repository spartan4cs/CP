import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        toh(n, a, b, c);

    }

    public static void toh(int n, int a, int b, int c) {
        if (n == 0)
            return;

        toh(n - 1, a, c, b);
        System.out.println(n + "[" + a + " -> " + b + "]");
        toh(n - 1, c, b, a);
    }
}
