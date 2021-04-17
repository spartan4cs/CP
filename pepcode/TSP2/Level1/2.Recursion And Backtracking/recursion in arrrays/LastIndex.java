import java.util.Scanner;

public class LastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int x = sc.nextInt();

        System.out.println(getLastIndex(0, arr, x));
    }

    public static int getLastIndex(int i, int[] arr, int x) {

        if (arr.length == i) {
            return -1;
        }

        int rindx = getLastIndex(i + 1, arr, x);
        if (rindx == -1) {

            if (arr[i] == x) {
                rindx = i;
            }
        }
        return rindx;
    }
}
