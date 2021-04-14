import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int stars = n;
        int spaces = 0;

        for (int i = 0; i < n; i++) {// no of rows

            // no of spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print("\t");
            }
            // no of stars
            for (int j = 0; j < stars; j++) {
                System.out.print("*\t");
            }
            System.out.println();
            stars--;
            spaces++;
        }
    }

}
