import java.util.Scanner;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            solution(i, n);
        }
    }

    private static void solution(int i, int n) {

        if (i > n) {
            return;
        } else {

            System.out.println(i);
            for (int j = 0; j < 10; j++) {
                solution(10 * i + j, n);
            }
        }
    }
}
