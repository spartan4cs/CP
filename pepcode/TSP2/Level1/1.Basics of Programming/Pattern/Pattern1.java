import java.util.Scanner;

class Pattern2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int stars = 1;
        for (int i = 0; i < n; i++) {// no of rows
            for (int j = 0; j < stars; j++) {// no of stars
                System.out.print("*\t");
            }
            stars++;
            System.out.println();
        }
    }
}