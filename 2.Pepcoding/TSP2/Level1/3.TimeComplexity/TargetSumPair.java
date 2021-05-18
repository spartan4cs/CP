import java.util.Arrays;
import java.util.Scanner;

public class TargetSumPair {
    public static void targetSumPair(int[] arr, int target) {
        // write your code here

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println(arr[left] + ", " + arr[right]);
                left++;
                right--;
            } else if (sum < target) {
                left++; // value increase honar
            } else if (sum > target) {
                right--; // value decrease honar
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr, target);
    }
}
