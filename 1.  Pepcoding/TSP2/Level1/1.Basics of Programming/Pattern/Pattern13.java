import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int ans = 1;
            // trying to find the next element
            // nC(k+1) = nCk *(n-k)/(k+1)
            for (int j = 0; j <= i; j++) {
                System.out.print(ans + "\t");
                ans = (ans * (i - j)) / (j + 1);
            }
            System.out.println();
        }

    }
}
