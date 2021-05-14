import java.util.*;

class Demo {
    public static void targetSS(int[] arr, int i, int tar, int ssf, String asf) {

        // base call
        if (i == arr.length) {
            if (ssf == tar)
                System.out.println(asf);
            return;
        }

        // yes call only if ssf+arr[i]<=tar
        if (ssf + arr[i] <= tar)
            targetSS(arr, i + 1, tar, ssf + arr[i], asf + arr[i] + ",");
        // no call
        targetSS(arr, i + 1, tar, ssf, asf);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        targetSS(arr, 0, tar, 0, "");

    }

}