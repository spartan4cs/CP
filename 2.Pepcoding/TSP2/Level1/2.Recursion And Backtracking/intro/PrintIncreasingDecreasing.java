import java.util.Scanner;

class PrintIncreasingDecreasing {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printIncDcr(n);

    }

    public static void printIncDcr(int n) {

        if (n == 0) {
            return;
        }
        System.out.println(n);// upar jate hue
        printIncDcr(n - 1);
        System.out.println(n);// niche ate hue4

    }
}