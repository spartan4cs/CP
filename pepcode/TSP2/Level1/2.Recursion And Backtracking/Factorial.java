import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = fact(n);
        System.out.println(a);
    }

    public static int fact(int n) {

        if (n == 1) {
            return 1;
        }
        int k = fact(n - 1);
        int ans = n * k;
        return ans;
    }
}
