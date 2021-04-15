import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stars = 1;
        int spaces = 2 * n - 3;
        for (int i = 0; i < n; i++) {
            // System.out.print(stars + " " + spaces + " " + stars);
            int counter = 1;
            for (int j = 0; j < stars; j++) {
                // System.out.print("*\t");
                System.out.print(counter + "\t");
                counter++;
            }
            for (int j = 0; j < spaces; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j < stars; j++) {
                // System.out.print("*\t");
                counter--;
                if (counter != n) {
                    System.out.print(counter + "\t");
                }

            }
            stars++;
            spaces -= 2;
            System.out.println();
        }
    }
}
