import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int stars = n / 2 + 1;
        int spaces = 1;
        for (int i = 0; i < n; i++) {
            // System.out.println(spaces + " " + stars);
            for (int j = 0; j < stars; j++) {
                System.out.print("*\t");
            }
            for (int j = 0; j < spaces; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("*\t");
            }
            // update stars and spaces
            if (i < n / 2) {
                stars--;
                spaces += 2;

            } else {
                stars++;
                spaces -= 2;
            }
            System.out.println();

        }
    }
}
