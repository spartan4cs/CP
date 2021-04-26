import java.util.Scanner;

class Pattern18 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int spaces = 0;
        int stars = n;

        for (int i = 0; i < n; i++) {
            // System.out.println(stars + " " + spaces);
            for (int j = 0; j < spaces; j++) {
                System.out.print("\t");
            }
            for (int j = 0; j < stars; j++) {
                // neeed to gove spaces at at upper half
                if (i > 0 && i < n / 2 && j > 0 && j < stars - 1) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }

            }
            if (i < n / 2) {
                stars -= 2;
                spaces++;
            } else {
                spaces--;
                stars += 2;
            }
            System.out.println();
        }
    }
}