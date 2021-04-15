import java.util.Scanner;

public class PowerLog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        // expectation
        int ans = powLog(x, n);
        System.out.println(ans);
    }

    public static int powLog(int x, int n) {

        // base
        if (n == 0) {
            return 1;
        }

        // faith
        int ans = powLog(x, n / 2);
        ans = ans * ans;
        if (n % 2 == 1) {
            ans *= x;
        }
        return ans;

    }
}
