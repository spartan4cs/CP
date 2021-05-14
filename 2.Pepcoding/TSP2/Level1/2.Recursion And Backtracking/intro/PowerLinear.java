import java.util.Scanner;

class PowerLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        // expectation
        int ans = powerL(x, n);
        System.out.println(ans);
    }

    public static int powerL(int x, int n) {

        if (n == 0) {
            return 1;

        }
        // faith
        int ans = powerL(x, n - 1);
        ans = x * ans;
        return ans;
    }
}