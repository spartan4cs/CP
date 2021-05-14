import java.util.Scanner;

public class Pattern3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stars = 1;
        int spaces = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaces; j++) {
                // no of spaces
                System.out.print("\t");
            }
            // no of stars
            for (int j = 0; j < stars; j++) {
                System.out.print("*\t");
            }
            stars++;
            spaces--;
            System.out.println();
        }
    }
}
