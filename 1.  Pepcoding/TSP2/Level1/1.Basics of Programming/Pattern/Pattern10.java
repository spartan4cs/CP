import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int os = n / 2;
        int is = -1;
        // try ot print outer space and inner space
        for (int i = 0; i < n; i++) {
            // System.out.println(is + " * " + os);

            for (int j = 0; j < os; j++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            for (int j = 0; j < is; j++) {
                System.out.print("\t");
            }
            if (i > 0 && i < n - 1) {
                System.out.print("*");
            }

            if (i < n / 2) {
                os--;
                is += 2;
            } else {
                os++;
                is -= 2;
            }
            System.out.println();
        }
    }
}
