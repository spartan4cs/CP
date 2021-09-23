import java.util.Scanner;

public class DisplayReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // 10 20 30 40 50
        }

        printReverse(0, arr);// expectation print 50 40 30 20 10

    }

    private static void printReverse(int index, int[] arr) {
        // base
        if (index == arr.length) {
            return;
        }

        // faith 40 30 20 10
        printReverse(index + 1, arr);
        System.out.println(arr[index]);

    }
}
