import java.util.*;
import java.util.Scanner;

public class Solution1 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target, String asf,
            List<List<Integer>> ans,currI) {
        // // write your code here
        if (target == 0) {
            List<Integer> bres = new ArrayList<>();
            // / bres.add(new ArrayList<>());
            for (int i = 0; i < asf.length(); i++) {
                bres.add(asf.charAt(i) - '0');
            }
            ans.add(bres);
            return ans;
        }
        if (target > 0) {
            for (int i = currI; i < candidates.length; i++) {
                ans = combinationSum(candidates, target - candidates[i], asf + candidates[i], ans);

            }

        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        List<List<Integer>> res = combinationSum(arr, target, "", new ArrayList<>(), 0);
        System.out.println(res);
    }
}