import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int ans = recursion(n, k);
        System.out.println(ans);

    }

    private static int recursion(int n, int k) {

        // base
        if (n == 1)
            return 0;

        int x = recursion(n - 1, k);

        int y = (x + k) % n;
        return y;
    }

}
