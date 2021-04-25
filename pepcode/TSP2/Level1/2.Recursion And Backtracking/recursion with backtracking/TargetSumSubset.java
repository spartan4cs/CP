import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int tar = sc.nextInt();
        printTargetSumSubsets(arr, 0, 0, tar, "");
    }

    // asf is the answer so far
    // ssf is sum so far
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, int ssf, int tar, String asf) {

        // base
        if (idx == arr.length) { // need to explore all the subsets
            if (ssf == tar) { // sum==targer

                System.out.println(asf + ".");
            }
            return;

        }

        // yes calls
        if (ssf + arr[idx] <= tar) // you will not get anything beyond target path so dont explore.
            printTargetSumSubsets(arr, idx + 1, ssf + arr[idx], tar, asf + arr[idx] + ", ");

        // no calls
        printTargetSumSubsets(arr, idx + 1, ssf, tar, asf);
    }
}
