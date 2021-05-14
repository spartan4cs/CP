import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int stars = 1;
        int spaces = n / 2;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < spaces; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("*\t");
            }

            // update stars and spaces
            if (i < n / 2) {
                stars++;
                stars++;
                spaces--;
            } else {
                stars--;
                stars--;
                spaces++;
            }
            System.out.println();
        }
    }
}
