import java.util.Scanner;

class DisplayArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // printRecursiveFromZero(0, a); // expectation print- 10 20 30 40 50
        printRecursiveFromBack(a.length - 1, a); // expectation print 10 20 30 40 50
    }

    public static void printRecursiveFromBack(int n, int[] a) {

        if (n < 0) {
            return;
        }
        printRecursiveFromBack(n - 1, a);// faith 10 20 30 40
        System.out.println(a[n]);
    }

    public static void printRecursiveFromZero(int n, int[] a) {

        if (n > a.length - 1) {
            return;
        }
        System.out.println(a[n]);
        printRecursiveFromZero(n + 1, a);// faith 20 30 40 50
    }
}