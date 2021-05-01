import java.util.Scanner;

public class PrimeNumberWithQueries {

    // seive
    public static boolean checkPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int arr[] = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (checkPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }
}
