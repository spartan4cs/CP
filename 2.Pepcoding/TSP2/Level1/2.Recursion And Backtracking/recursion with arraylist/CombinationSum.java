import java.util.*;
import java.io.*;

// 1. Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
// 2. The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
// 3. It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Input Format

// candidates = [2,3,6,7], target = 7
// Constraints

// 1. 1 <= candidates.length <= 30
// 2. 1 <= candidates[i] <= 200
// 3. All elements of candidates are distinct.
// 4. 1 <= target <= 500
// Output Format

// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Sample Input 0

// 4
// 2 3 6 7
// 7
// Sample Output 0

// [[2, 2, 3], [7]]
class CombinationalSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target, String asf, List<List<Integer>> ans,
            int currI) {
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
                ans = combinationSum(candidates, target - candidates[i], asf + candidates[i], ans, i);

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
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> res = combinationSum(arr, target, "", ans, 0);
        System.out.println(res);
    }
}