import java.util.*;
import java.io.*;

class Leet698_PartitiontoKEqualSumSubsets {
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums[] = { 4, 3, 2, 3, 5, 2, 1 };
        int k = 4;

        System.out.println(canPartitionKSubsets(nums, k));

    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        solution(nums, 0, k, "", 0, new int[k]);
        return flag;
    }

    // nos- no of set filled
    private static void solution(int[] nums, int i, int k, String asf, int nos, int[] ans) {

        if (i == nums.length) {
            if (nos == k) {
                // for (int j : ans) {
                // System.out.print(j + " ");
                // }
                // System.out.println();
                boolean allMatch = Arrays.stream(ans).allMatch(t -> t == ans[0]);
                if (allMatch) {
                    flag = true;

                    return;
                }
            }
            return;
        }

        for (int j = 0; j < k; j++) {

            if (ans[j] != 0) {
                ans[j] += nums[i];
                solution(nums, i + 1, k, asf, nos, ans);
                ans[j] -= nums[i];
            }
            // empy set
            if (ans[j] == 0) {

                ans[j] += nums[i];
                solution(nums, i + 1, k, asf, nos + 1, ans);
                ans[j] -= nums[i];
                break;// to avoid multiple times adding to empty set
            }
        }
    }
}