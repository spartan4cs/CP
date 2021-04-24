import java.util.Scanner;

public class PrintStairPath {

    public static void printStairPath(int n, String asf) {

        if (n < 0) {
            return;
        } else if (n == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 1; i <= 3; i++) { // no of options

            printStairPath(n - i, asf+i);
        }
    }

    public static void main(String[] args) {

        // int n = 3;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStairPath(n, "");
    }

}
