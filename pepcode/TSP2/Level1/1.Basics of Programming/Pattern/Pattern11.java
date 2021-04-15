import java.util.Scanner;

class Pattern11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counter = 1;
        int stars = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < stars; j++) {
                System.out.print(counter + "\t");
                counter++;
            }
            stars++;

            System.out.println();
        }
    }
}