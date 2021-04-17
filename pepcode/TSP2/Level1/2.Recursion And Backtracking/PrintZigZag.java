import java.util.Scanner;

public class PrintZigZag {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        zigzag(n);

    }

    public static void zigzag(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n + " ");
        zigzag(n - 1);
        System.out.println(n + " ");
        zigzag(n - 1);
        System.out.println(n + " ");
    }
}
