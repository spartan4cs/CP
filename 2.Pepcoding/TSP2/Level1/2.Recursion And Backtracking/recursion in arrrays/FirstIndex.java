import java.util.Scanner;

public class FirstIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int x = sc.nextInt();

        System.out.println(getFirstIndex(0, arr, x));

    }

    public static int getFirstIndex(int i, int[] arr, int x) {

        if (arr.length == i) {
            return -1;
        }
        if (arr[i] == x) {
            return i;
        }

        // faith

        int rindex = getFirstIndex(i + 1, arr, x);

        return rindex;
    }
}
